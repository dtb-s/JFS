package lesson09;

import java.lang.reflect.Field;

/**
 * 练习 2：反射访问私有字段
 * 配套笔记：notes/09-反射与注解.md 第 3 节
 * <p>
 * 题目：补全代码，使输出符合"预期"。
 */
public class Exercise02 {

    public static void main(String[] args) throws Exception {
        // TODO 1：创建 User("张三", 25)，打印 getter 值，预期：张三 25

        // TODO 2：反射修改私有字段 name
        // 用 getDeclaredField("name")，setAccessible(true)，set(obj, "李四")
        // 用 get() 读回并打印，预期：李四

        // TODO 3：反射修改私有 final 字段（选做）
        // 尝试修改 age 为 30，观察能不能成功，把现象写在注释里
        // 提示：final 字段在 Java 17+ 反射修改会抛 InaccessibleObjectException 或无效
    }
}

// 已有类，直接使用
class User {
    private String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}