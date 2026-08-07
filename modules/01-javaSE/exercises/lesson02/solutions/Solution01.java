package lesson02.solutions;

/**
 * 练习 1 参考答案：类、构造方法、封装
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) {
        // 无参构造
        Student s1 = new Student();

        // setter 赋值
        s1.setName("小明");
        s1.setAge(18);
        s1.introduce();   // 我叫小明，今年 18 岁

        // 有参构造
        Student s2 = new Student("小红", 20);
        s2.introduce();   // 我叫小红，今年 20 岁

        // 年龄校验
        s1.setAge(-5);    // 年龄不合法：-5
        s1.setAge(25);
        System.out.println(s1.getAge());   // 25

        // 选做
        s1.setAge(200);   // 年龄不合法：200
    }
}

class Student {
    private String name;
    private int age;

    Student() {
        this("未命名", 0);
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("年龄不合法：" + age);
            return;   // 拒绝修改
        }
        this.age = age;
    }

    void introduce() {
        System.out.println("我叫" + name + "，今年" + age + "岁");
    }
}