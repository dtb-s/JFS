package lesson07.solutions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 练习 3 参考答案：对象序列化
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "out/student.ser";
        new java.io.File("out").mkdirs();

        // TODO 1：序列化写入
        Student student = new Student("小明", 18, "123456");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(student);
        }

        // TODO 2：反序列化读取
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Student read = (Student) ois.readObject();
            System.out.println(read.getName() + " " + read.getAge());   // 小明 18
            System.out.println(read.getPassword());                     // null
        }

        // TODO 3 答案：去掉 transient 后 password 会被序列化，读出来是 "123456"。
        // transient 用于标记敏感/不需要持久化的字段。
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String password;

    Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassword() { return password; }
}