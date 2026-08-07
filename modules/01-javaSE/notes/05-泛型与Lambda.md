# 05-泛型与Lambda

> 预计用时：4～5 小时（读笔记 2 小时 + 做练习 2～3 小时）
> 配套练习：`modules/01-javaSE/exercises/lesson05/`（包名 `lesson05`）

## 本课目标

1. 理解泛型的作用：类型安全 + 消除强制转换
2. 会写泛型类、泛型方法，理解通配符 `? extends` / `? super`
3. 掌握 Lambda 表达式语法，理解函数式接口
4. 熟悉 `Predicate` / `Consumer` / `Function` / `Supplier` 四个内置接口
5. 会用 Stream 做过滤、映射、收集

---

## 1. 为什么需要泛型

没有泛型时，集合里装什么都可以，取出来必须强转，还容易转错：

```java
// 没有泛型：任何对象都能放进去
List list = new ArrayList();
list.add("hello");
list.add(123);                    // 不小心放了个数字

// 取出时强转，运行期才可能炸
String s = (String) list.get(1);  // ClassCastException！
```

有了泛型，**编译期**就保证类型正确：

```java
List<String> list = new ArrayList<>();
list.add("hello");
// list.add(123);                 // 编译错误：类型不匹配
String s = list.get(0);           // 不需要强转
```

---

## 2. 泛型类

```java
// T 是类型参数，创建对象时确定
public class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

Box<String> box1 = new Box<>();
box1.set("hello");
String s = box1.get();        // 不需要强转

Box<Integer> box2 = new Box<>();
box2.set(42);
```

**多类型参数：**

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

Pair<String, Integer> p = new Pair<>("age", 18);
```

---

## 3. 泛型方法

泛型方法在**返回值前**声明类型参数：

```java
public class Utils {
    // <T> 表示这是一个泛型方法；T 由参数推断
    public static <T> T first(List<T> list) {
        return list.get(0);
    }
}

String s = Utils.first(List.of("a", "b"));
Integer n = Utils.first(List.of(1, 2));
```

---

## 4. 通配符（面试重点）

**问题：** `List<Object>` 和 `List<String>` 是什么关系？答案：**没有继承关系**！`List<String>` 不能赋给 `List<Object>`。

```java
void print(List<Object> list) { }   // 传 List<String> 会编译错误！
```

需要接受"任意类型"的 List 时，用通配符：

```java
void print(List<?> list) {          // ? 表示未知类型，只能读不能写（除了 null）
    for (Object o : list) {
        System.out.println(o);
    }
}
```

**上界 / 下界（PECS 口诀）：**

```java
// ? extends T：读"T 或其子类"（Producer Extends —— 用来读）
void readAll(List<? extends Number> list) {
    for (Number n : list) { }       // 可以读，保证是 Number
}

// ? super T：写"T 或其父类"（Consumer Super —— 用来写）
void addAll(List<? super Integer> list) {
    list.add(42);                   // 可以写，Integer 一定能放进去
}
```

**类型擦除（了解）：** 泛型只在编译期有效。编译后 `List<String>` 和 `List<Integer>` 是同一个类，类型参数被擦除成 `Object`。所以运行期**不能** `instanceof List<String>`，只能 `instanceof List`。

---

## 5. 函数式接口

**函数式接口 = 只有一个抽象方法的接口**。加 `@FunctionalInterface` 让编译器帮你检查。

```java
@FunctionalInterface
interface MyFunction {
    int apply(int x);
}
```

Lambda 就是"函数式接口的匿名实现"的简写。

---

## 6. Lambda 表达式

**语法：** `(参数) -> 表达式 或 {语句块}`

```java
// 匿名内部类（以前）
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("hello");
    }
};

// Lambda（现在）：run() 无参数，方法体一句话
Runnable r2 = () -> System.out.println("hello");
```

**演化过程（重点理解）：**

```java
// 原始：匿名内部类
Collections.sort(list, new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
});

// 简化 1：去掉类型（类型可推断）
Collections.sort(list, (a, b) -> a - b);

// 简化 2：用 Integer 自带比较器
Collections.sort(list, Integer::compareTo);
```

**规则：**
- 参数类型可以省略（编译器推断）
- 单参数可以省略括号：`s -> s.length()`
- 语句块只有一行时省略 `{}` 和 `return`
- Lambda 捕获的局部变量必须是 **effectively final**（赋值后不再修改）

---

## 7. 四个内置函数式接口（背下来）

| 接口 | 抽象方法 | 用途 |
| --- | --- | --- |
| `Predicate<T>` | `boolean test(T)` | 判断真假，过滤 |
| `Consumer<T>` | `void accept(T)` | 消费，无返回值 |
| `Function<T, R>` | `R apply(T)` | 转换，T 进 R 出 |
| `Supplier<T>` | `T get()` | 生产，无参有返回 |

```java
import java.util.function.*;

Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4));    // true

Consumer<String> printer = s -> System.out.println(s);
printer.accept("hello");

Function<String, Integer> length = s -> s.length();
System.out.println(length.apply("java"));   // 4

Supplier<Double> random = () -> Math.random();
System.out.println(random.get());
```

---

## 8. 方法引用（了解）

Lambda 的另一种写法，双冒号 `::`：

```java
list.forEach(s -> System.out.println(s));
list.forEach(System.out::println);        // 等价：对象::方法

list.sort((a, b) -> Integer.compare(a, b));
list.sort(Integer::compareTo);            // 等价：类::静态方法

// 构造方法引用
Supplier<ArrayList<String>> factory = ArrayList::new;
```

能用方法引用时更简洁，但不强求，看不惯就写完整 Lambda。

---

## 9. Stream 流（重点，日常高频）

**思想：** 把集合当成一条"流水线"，链式调用操作，最后收集结果。**Stream 不修改原集合**。

```java
import java.util.List;
import java.util.stream.Collectors;

List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

// 过滤偶数 → 翻倍 → 收集成新列表
List<Integer> result = nums.stream()
        .filter(n -> n % 2 == 0)       // 中间操作：过滤
        .map(n -> n * 2)               // 中间操作：映射
        .collect(Collectors.toList()); // 终止操作：收集
System.out.println(result);   // [4, 8, 12]
```

**常用操作：**

| 操作 | 作用 | 示例 |
| --- | --- | --- |
| `filter` | 过滤 | `.filter(n -> n > 3)` |
| `map` | 转换 | `.map(s -> s.length())` |
| `sorted` | 排序 | `.sorted()` |
| `distinct` | 去重 | `.distinct()` |
| `limit` | 取前 n 个 | `.limit(3)` |
| `count` | 计数 | `.count()` |
| `forEach` | 遍历 | `.forEach(System.out::println)` |
| `collect` | 收集回集合 | `.collect(Collectors.toList())` |

**对象示例：**

```java
// 找出成绩及格的学生姓名，按分数降序
List<String> names = students.stream()
        .filter(s -> s.getScore() >= 60)
        .sorted((a, b) -> b.getScore() - a.getScore())
        .map(Student::getName)
        .collect(Collectors.toList());
```

**分组（了解）：**

```java
Map<Integer, List<Student>> byGrade = students.stream()
        .collect(Collectors.groupingBy(s -> s.getScore() / 10));
```

---

## 10. 用 AI 辅助这一课

**让 AI 出简化题：**

```text
把下面这段匿名内部类改写成 Lambda（贴代码）。
我写完后你再给答案，先别直接改。
```

**让 AI 讲解 PECS：**

```text
用通俗例子解释 ? extends T 和 ? super T 分别什么时候用，
配一个最小代码示例。
```

**让 AI review Stream：**

```text
这是我写的 Stream 代码（贴代码）。它和 for 循环版本等价吗？
有没有更符合惯例的写法？不要直接重写，给建议。
```

---

## 11. 本课练习与验收

打开 `exercises/lesson05/`，按 README 的流程完成 3 个练习。

**验收标准（全部满足才算过关）：**

- [ ] 3 个练习独立完成（没看答案）
- [ ] 每个程序能编译运行，输出与预期一致
- [ ] 能向别人解释：泛型解决了什么问题、`List<Object>` 和 `List<String>` 为什么没关系、PECS 口诀
- [ ] 能手写四个内置函数式接口的签名
- [ ] 把写好的代码发给我 review