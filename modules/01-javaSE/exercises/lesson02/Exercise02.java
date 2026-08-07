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
        Animal a1 = new Dog("D");
        Animal a2 = new Cat("C");
        a1.speak();
        a2.speak();
        // TODO 2：多态方法
        // 调用 makeItSpeak(...) 传入上面两个对象，预期输出同上
        makeItSpeak(a1);
        makeItSpeak(a2);
        // TODO 3：向下转型
        // 把 dog 引用先用 instanceof 判断，再转回 Dog 类型
        // 调用 fetch()，预期输出：旺财叼回了球
        if (a1 instanceof Dog) {
            Dog d = (Dog) a1;
            d.fetch();
        }
        // TODO 4（选做）：类型判断
        // 把 cat 直接强转成 Dog 并调用 fetch()，观察运行时报错
        // 做完记得把报错的那行注释掉，保持程序能正常运行
        // 观察完报错后按题目要求注释掉，保证程序正常运行
        // Dog d2 = (Dog) a2;
        // d2.fetch();
    }

    // TODO：补全这个方法，使任意 Animal 子类都能传进来并正确发声
    static void makeItSpeak(Animal animal) {
        // 你的代码
        animal.speak();
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
class Dog extends Animal {
    // 你的代码
    Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(this.name + "wowowow");
    }

    public void fetch() {
        System.out.println(this.name + "fetch the ball");
    }

}

// TODO：Cat 继承 Animal
// 1. 构造方法：调用 super(name)
// 2. 重写 speak()：打印 name + "喵喵叫"（记得加 @Override）
class Cat extends Animal {
    // 你的代码
    Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(this.name + "miaomiaomiao");
    }
}