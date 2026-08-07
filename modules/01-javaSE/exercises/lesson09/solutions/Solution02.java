package lesson09.solutions;

import java.lang.reflect.Field;

/**
 * 练习 2 参考答案：反射访问私有字段
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) throws Exception {
        User user = new User("张三", 25);
        System.out.println(user.getName() + " " + user.getAge());   // 张三 25

        // 反射修改私有字段
        Class<?> clazz = User.class;
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(user, "李四");
        System.out.println(nameField.get(user));   // 李四
        System.out.println(user.getName());        // 李四

        // 选做：final 字段（age）在 Java 17+ 反射修改基本类型通常不生效，
        // 或抛 InaccessibleObjectException（模块化限制）。结论：别试图改 final。
    }
}

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