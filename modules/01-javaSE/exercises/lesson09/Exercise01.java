package lesson09;

/**
 * 练习 1：获取 Class 与反射调用
 * 配套笔记：notes/09-反射与注解.md 第 2、3 节
 * <p>
 * 题目：补全代码，使输出符合"预期"。
 */
public class Exercise01 {

    public static void main(String[] args) throws Exception {
        // TODO 1：三种方式获取 Class 对象
        // 方式一：Student.class
        // 方式二：new Student("临时").getClass()
        // 方式三：Class.forName("lesson09.Student")
        // 打印三个是否相等，预期：true（类只加载一次）

        // TODO 2：反射创建对象
        // 用 clazz.getConstructor(String.class, int.class).newInstance("小明", 18)
        // 强转成 Student 并调用 introduce()，预期：我叫小明，今年18岁

        // TODO 3：反射调用方法
        // 用 getMethod("introduce") 拿到方法，invoke 到刚才的对象上
        // 再 getMethod("study", String.class) 传 "数学"，预期：小明正在学习数学

        // TODO 4（选做）：Class.forName 加载不存在的类
        // Class.forName("lesson09.NotExist")，观察抛什么异常，然后注释掉
        // 答案写在注释里：ClassNotFoundException
    }
}

// 已有类，直接使用
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