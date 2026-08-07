package lesson07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 练习 3：对象序列化
 * 配套笔记：notes/07-I-O流.md 第 5 节
 * <p>
 * 题目：把 Student 对象存进文件，再读回来打印。
 */
public class Exercise03 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "out/student.ser";

        // TODO 1：序列化写入
        // 创建 Student("小明", 18, "123456")
        // 用 ObjectOutputStream + FileOutputStream 写入 path

        // TODO 2：反序列化读取
        // 用 ObjectInputStream + FileInputStream 读回，强转成 Student
        // 打印 getName() + getAge()，预期：小明 18
        // 打印 getPassword()，预期：null（transient 字段不参与序列化）

        // TODO 3（选做）：回答
        // 把 password 的 transient 去掉再跑一次，观察输出变化，把结论写注释里
    }
}

// TODO：让 Student 实现 Serializable，并加 serialVersionUID
// 1. 字段：String name、int age、String password
// 2. password 加 transient 修饰（不参与序列化）
// 3. 构造 + getter
class Student {
    // 你的代码
}