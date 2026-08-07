package lesson02;

/**
 * 练习 2：继承、重写、多态
 * 配套笔记：notes/02-面向对象.md 第 5~6 节
 * <p>
 * 题目：补全 Dog、Cat 类（继承 Animal），并完成 main 中的测试。
 */
public class Exercise02 {

    public static void main(String[] args) {
        // TODO 1：向上转型
        // 创建 Dog("旺财") 和 Cat("咪咪")，用 Animal 类型的引用接收
        // 调用 speak()，预期输出：
        // 旺财汪汪叫
        // 咪咪喵喵叫

        // TODO 2：多态方法
        // 调用 makeItSpeak(...) 传入上面两个对象，预期输出同上

        // TODO 3：向下转型
        // 把 dog 引用先用 instanceof 判断，再转回 Dog 类型
        // 调用 fetch()，预期输出：旺财叼回了球

        // TODO 4（选做）：类型判断
        // 把 cat 直接强转成 Dog 并调用 fetch()，观察运行时报错
        // 做完记得把报错的那行注释掉，保持程序能正常运行
    }

    // TODO：补全这个方法，使任意 Animal 子类都能传进来并正确发声
    static void makeItSpeak(Animal animal) {
        // 你的代码
    }
}

// 父类：已有实现，直接使用
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void speak() {
        System.out.println(name + "发出声音");
    }
}

// TODO：Dog 继承 Animal
// 1. 构造方法：调用 super(name)
// 2. 重写 speak()：打印 name + "汪汪叫"（记得加 @Override）
// 3. 新增方法 fetch()：打印 name + "叼回了球"
class Dog {
    // 你的代码
}

// TODO：Cat 继承 Animal
// 1. 构造方法：调用 super(name)
// 2. 重写 speak()：打印 name + "喵喵叫"（记得加 @Override）
class Cat {
    // 你的代码
}