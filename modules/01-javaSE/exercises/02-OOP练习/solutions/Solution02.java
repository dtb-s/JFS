/**
 * 练习 2 参考答案：继承、重写、多态
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        // 向上转型：父类引用指向子类对象
        Animal dog = new Dog("旺财");
        Animal cat = new Cat("咪咪");

        dog.speak();   // 旺财汪汪叫（动态绑定）
        cat.speak();   // 咪咪喵喵叫

        // 多态方法
        makeItSpeak(dog);
        makeItSpeak(cat);

        // 向下转型
        if (dog instanceof Dog) {
            Dog d = (Dog) dog;
            d.fetch();   // 旺财叼回了球
        }

        // 选做：直接强转会抛 ClassCastException
        // Dog bad = (Dog) cat;
    }

    static void makeItSpeak(Animal animal) {
        animal.speak();
    }
}

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void speak() {
        System.out.println(name + "发出声音");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println(name + "汪汪叫");
    }

    void fetch() {
        System.out.println(name + "叼回了球");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println(name + "喵喵叫");
    }
}