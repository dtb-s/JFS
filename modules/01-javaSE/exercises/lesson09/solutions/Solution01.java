package lesson09.solutions;

/**
 * 练习 1 参考答案：获取 Class 与反射调用
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) throws Exception {
        // 三种方式
        Class<?> c1 = Student.class;
        Class<?> c2 = new Student("临时", 0).getClass();
        Class<?> c3 = Class.forName("lesson09.solutions.Student");
        System.out.println(c1 == c2);   // true
        System.out.println(c1 == c3);   // true

        // 反射创建对象
        Student s = (Student) c1.getConstructor(String.class, int.class)
                .newInstance("小明", 18);
        s.introduce();   // 我叫小明，今年18岁

        // 反射调用方法
        c1.getMethod("introduce").invoke(s);
        c1.getMethod("study", String.class).invoke(s, "数学");   // 小明正在学习数学

        // 选做：Class.forName("lesson09.solutions.NotExist") 抛 ClassNotFoundException
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("我叫" + name + "，今年" + age + "岁");
    }

    public void study(String subject) {
        System.out.println(name + "正在学习" + subject);
    }
}