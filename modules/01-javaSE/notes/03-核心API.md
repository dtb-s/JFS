# 03-核心API

> 预计用时：4～5 小时（读笔记 2 小时 + 做练习 2～3 小时）
> 配套练习：`modules/01-javaSE/exercises/lesson03/`（包名 `lesson03`）

## 本课目标

1. 掌握 `Object` 的 `toString` / `equals` / `hashCode`
2. 熟练使用 `String` 常用方法，理解不可变性和常量池
3. 掌握包装类的装箱/拆箱和 `Integer` 缓存陷阱
4. 掌握新日期 API（`LocalDate` / `LocalDateTime` / `DateTimeFormatter`）
5. 掌握 `BigDecimal` 解决浮点精度问题
6. 具备查阅 JavaDoc 文档的能力

---

## 1. API 是什么？怎么查文档？

**API**（Application Programming Interface）= JDK 给你准备好的现成工具类和方法。学 API 的核心不是背，而是**知道有什么、会查怎么用**。

**JavaDoc 官方文档（对应你机器上的 JDK 25）：**

```text
https://docs.oracle.com/en/java/javase/25/docs/api/
```

**读一个类的方法时看五个要素：**

| 要素 | 例子 |
| --- | --- |
| 方法签名 | `int indexOf(String str)` |
| 参数含义 | 要查找的字符串 |
| 返回值 | 第一次出现的下标，找不到返回 -1 |
| 异常 | 传入 null 会抛 NPE |
| 版本 | Java 11 新增 `isBlank()` |

**让 AI 辅助查文档（推荐）：**

```text
我想在 Java 里把字符串按逗号拆成数组，JDK 里有什么方法？
给出方法签名和最小示例，不要展开讲。
```

---

## 2. Object 类：所有类的祖先

所有类都继承 `Object`，所以下面三个方法**每个对象都有**：

**toString() —— 对象的"自我介绍"**

```java
// 默认实现：类名@地址，比如 lesson03.Student@3fee733d
// 不重写的话打印出来没意义，所以要重写：
@Override
public String toString() {
    return "Student{name='" + name + "', age=" + age + "}";
}
```

**equals() —— 比较"内容"还是"地址"？**

```java
String a = new String("hello");
String b = new String("hello");
System.out.println(a == b);       // false：== 比较的是地址（两个不同对象）
System.out.println(a.equals(b));  // true：String 重写了 equals，比较内容
```

- `==`：基本类型比值，引用类型比地址
- `equals`：默认也是比地址（等价于 ==），**String 等类重写过才比内容**
- 自己的类要比较内容，必须重写 `equals`

**hashCode() —— 与 equals 的约定（先记住，集合课深化）：**

> 两个对象 equals 相等，hashCode 必须相等。反过来不成立。

**IDEA 技巧：** 右键 → Generate → equals() and hashCode() 可以自动生成，但学习阶段建议手写一遍。

---

## 3. String 类（本课重点）

### 3.1 不可变性

`String` 是 `final class`，创建后**内容不可变**。所有"修改"操作其实都是**创建一个新字符串**：

```java
String s = "hello";
s = s.toUpperCase();   // 不是修改了 s，而是创建了 "HELLO" 再重新赋值
```

**字符串常量池（面试考点）：**

```java
String a = "hello";          // 字面量：去常量池找，没有就创建
String b = "hello";          // 常量池已有，直接复用
System.out.println(a == b);  // true！字面量相同地址

String c = new String("hello");  // new 强制创建新对象（不复用常量池）
System.out.println(a == c);      // false
```

### 3.2 常用方法（先混个脸熟，练习里会用）

| 方法 | 作用 | 示例 |
| --- | --- | --- |
| `length()` | 长度 | `"abc".length()` → 3 |
| `charAt(i)` | 取第 i 个字符 | `"abc".charAt(1)` → 'b' |
| `indexOf(s)` | 首次出现下标，没有返回 -1 | `"abc".indexOf("b")` → 1 |
| `substring(begin)` | 从 begin 截到尾 | `"hello".substring(2)` → "llo" |
| `substring(b, e)` | 截取 [b, e)，**e 不包含** | `"hello".substring(1, 3)` → "el" |
| `contains(s)` | 是否包含 | `"hello".contains("ell")` → true |
| `startsWith` / `endsWith` | 前缀/后缀 | `"a.txt".endsWith(".txt")` → true |
| `equalsIgnoreCase` | 忽略大小写比较 | `"A".equalsIgnoreCase("a")` → true |
| `toLowerCase` / `toUpperCase` | 大小写转换 | `"Abc".toUpperCase()` → "ABC" |
| `trim()` | 去首尾空格 | `"  a  ".trim()` → "a" |
| `replace(a, b)` | 替换所有 | `"a-b".replace("-", "+")` → "a+b" |
| `split(reg)` | 按正则拆成数组 | `"a,b".split(",")` → ["a", "b"] |
| `isEmpty()` | 是否空串 | `"".isEmpty()` → true |
| `isBlank()` | 空或全空白（Java 11+） | `"  ".isBlank()` → true |
| `format(...)` | 格式化 | 见下 |
| `join(delim, parts)` | 拼接 | `String.join("-", "a", "b")` → "a-b" |

**格式化输出：**

```java
String s = String.format("姓名：%s，年龄：%d，分数：%.2f", "小明", 18, 85.5);
System.out.println(s);   // 姓名：小明，年龄：18，分数：85.50
// %s 字符串，%d 整数，%.2f 保留两位小数的浮点数，%n 换行
```

### 3.3 StringBuilder：可变字符串（性能关键）

**为什么需要它？** 循环里用 `+` 拼接会不断创建新对象，慢且浪费内存：

```java
// 慢：循环 1 万次，创建约 1 万个中间字符串
String s = "";
for (int i = 0; i < 10000; i++) {
    s += i;
}

// 快：只用一个可变的"缓冲区"
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append(i);
}
String s = sb.toString();
```

**常用方法：**

```java
StringBuilder sb = new StringBuilder("abc");
sb.append("d");          // 追加 → "abcd"
sb.insert(1, "X");       // 插入 → "aXbcd"
sb.delete(1, 2);         // 删除 [1,2) → "abcd"
sb.reverse();            // 反转 → "dcba"
String result = sb.toString();
```

- `StringBuilder`：非线程安全（日常首选）
- `StringBuffer`：线程安全（性能稍慢，多线程课再深入）
- 单线程拼接用 StringBuilder；不要为了"安全"盲目用 StringBuffer

---

## 4. 包装类（本课重点）

### 4.1 为什么需要包装类

基本类型不是对象，但有些场景必须要对象：

1. 集合（ArrayList 等）只能放对象 —— 集合课会用到
2. 需要 `null` 表示"没有值"（基本类型不能是 null）
3. 基本类型没有方法，包装类有

| 基本类型 | 包装类 |
| --- | --- |
| byte | Byte |
| short | Short |
| int | **Integer** |
| long | Long |
| float | Float |
| double | Double |
| char | **Character** |
| boolean | Boolean |

### 4.2 自动装箱和拆箱

```java
Integer n = 100;      // 装箱：编译器自动变成 Integer.valueOf(100)
int m = n;            // 拆箱：编译器自动变成 n.intValue()
```

记住：**`==` 在拆箱后比较数值，`equals` 在装箱对象之间比较数值**（这是缓存陷阱的根源）。

### 4.3 Integer 缓存陷阱（面试必考）

```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b);    // true：valueOf 对 -128~127 返回缓存对象

Integer c = 128;
Integer d = 128;
System.out.println(c == d);    // false：超出缓存范围，每次 new 新对象

System.out.println(c.equals(d));  // true：equals 永远比较数值
```

**规则：** 包装类比较数值，一律用 `equals`（或拆箱后的基本类型），不要用 `==`。

### 4.4 字符串 ↔ 数字转换（高频）

```java
// 字符串 → int
int n = Integer.parseInt("42");        // 最常用
Integer n2 = Integer.valueOf("42");    // 返回包装类

// int → 字符串
String s1 = String.valueOf(42);        // 推荐
String s2 = Integer.toString(42);
String s3 = "" + 42;                   // 能用但不推荐（底层是 StringBuilder）

// 进制转换
int x = Integer.parseInt("1010", 2);   // 二进制 "1010" → 十进制 10
String bin = Integer.toBinaryString(42);  // 十进制 42 → "101010"
```

**常见异常：** `Integer.parseInt("abc")` 会抛 `NumberFormatException`（异常课细讲，现在先认识它）。

### 4.5 Character 常用

```java
Character.isDigit('5');      // true
Character.isLetter('A');     // true
Character.isWhitespace(' '); // true
Character.toUpperCase('a');  // 'A'
```

---

## 5. 日期时间 API

### 5.1 旧 API（面试会问"为什么不用"）

```java
Date d = new Date();          // 还能用，但大部分方法已废弃
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 非线程安全
Calendar c = Calendar.getInstance();  // 可变、月份从 0 开始、API 难用
```

**旧 API 三个问题：** 设计混乱（月份从 0 计数）、可变（多线程不安全）、麻烦。Java 8 推出了新 API 取代它们。

### 5.2 新 API（重点，Java 8+）

**LocalDate（日期）/ LocalTime（时间）/ LocalDateTime（日期+时间）：**

```java
// 创建
LocalDate today = LocalDate.now();                 // 今天
LocalDate born = LocalDate.of(2000, 5, 20);        // 指定日期
LocalDateTime now = LocalDateTime.now();           // 日期+时间

// 读取
int year = today.getYear();
int month = today.getMonthValue();   // 1~12（不是 0 开始！）
int day = today.getDayOfMonth();

// 运算（返回新对象，原对象不变）
LocalDate nextMonth = today.plusMonths(1);
LocalDate before = today.minusDays(100);
boolean after = today.isAfter(born);   // true

// 比较间隔
Period period = Period.between(born, today);
int age = period.getYears();           // 完整经过的年数
```

**格式化：**

```java
DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
LocalDateTime now = LocalDateTime.now();
String text = now.format(f);        // 对象 → 字符串
LocalDateTime parsed = LocalDateTime.parse("2026-08-07 18:30:00", f);  // 字符串 → 对象
```

**常用模式字母：** `yyyy` 年、`MM` 月、`dd` 日、`HH` 24小时、`mm` 分钟、`ss` 秒。

**新旧对比：**

| 对比 | 旧（Date/Calendar） | 新（LocalDate/LocalDateTime） |
| --- | --- | --- |
| 可变性 | 可变 | 不可变（线程安全） |
| 月份 | 0 开始 | 1 开始 |
| 格式 | SimpleDateFormat（线程不安全） | DateTimeFormatter（线程安全） |
| 计算 | Calendar 手动 set | plus/minus 链式调用 |

---

## 6. BigDecimal：精确小数（重点）

### 6.1 浮点精度问题

```java
double a = 0.1;
double b = 0.2;
System.out.println(a + b);   // 0.30000000000000004 ！不是 0.3
```

二进制无法精确表示 0.1，所以 double 天生有误差。**金额计算必须用 BigDecimal**。

### 6.2 基本用法

```java
// 构造：必须用字符串！用 double 构造等于把误差也带进来
BigDecimal price = new BigDecimal("19.9");

// 运算：加、减、乘、除
BigDecimal total = price.add(new BigDecimal("0.1"));
BigDecimal diff = price.subtract(new BigDecimal("5"));
BigDecimal multi = price.multiply(new BigDecimal("3"));
BigDecimal div = price.divide(new BigDecimal("2"));   // 能除尽才行
```

### 6.3 除不尽怎么办（高频坑）

```java
// 1 / 3 除不尽：不指定精度直接抛 ArithmeticException
// 必须指定：精度（几位小数）+ 舍入模式
BigDecimal result = new BigDecimal("1").divide(
        new BigDecimal("3"),
        4,                          // 保留 4 位小数
        RoundingMode.HALF_UP        // 四舍五入
);
System.out.println(result);   // 0.3333
```

**常用舍入模式：** `HALF_UP`（四舍五入）、`HALF_DOWN`、`UP`（远离零）、`DOWN`（向零）。

### 6.4 setScale 和 compareTo

```java
BigDecimal price = new BigDecimal("19.9");
BigDecimal total = price.multiply(new BigDecimal("3"));   // 59.7
BigDecimal rounded = total.setScale(2, RoundingMode.HALF_UP);  // 59.70

// 比较：不要用 equals！equals 连精度一起比（1.0 != 1.00）
System.out.println(new BigDecimal("1.0").equals(new BigDecimal("1.00")));  // false
System.out.println(new BigDecimal("1.0").compareTo(new BigDecimal("1.00")) == 0);  // true
```

---

## 7. Math 类（了解一下）

```java
Math.abs(-5);        // 5
Math.max(3, 7);      // 7
Math.min(3, 7);      // 3
Math.pow(2, 10);     // 1024.0
Math.sqrt(16);       // 4.0
Math.round(3.6);     // 4（四舍五入）
Math.random();       // [0, 1) 随机数
```

---

## 8. 用 AI 辅助这一课

**让 AI 出题巩固记忆：**

```text
给我 10 道 String 方法的小题（如 indexOf 找不到返回什么），
我答完你再给答案和解析。
```

**让 AI 解释你遇到的异常：**

```text
我执行 Integer.parseInt("abc") 抛了 NumberFormatException，
这个异常是什么意思？生产环境里一般怎么处理？
```

**让 AI 对比 API：**

```text
StringBuilder 和 StringBuffer 的区别是什么？String 的 + 拼接
在循环里为什么慢？各给一个最小示例。
```

**三条原则：** 先自己查文档 → 再看 AI 的解释 → 最后自己写一遍。

---

## 9. 本课练习与验收

打开 `exercises/lesson03/`，按 README 的流程完成 3 个练习。

**验收标准（全部满足才算过关）：**

- [ ] 3 个练习独立完成（没看答案）
- [ ] 每个程序能编译运行，输出与预期一致
- [ ] 能向别人解释：`==` vs `equals`、Integer 缓存陷阱、为什么金额计算用 BigDecimal
- [ ] 能说出 `String` 和 `StringBuilder` 各自适合什么场景
- [ ] 把写好的代码发给我 review