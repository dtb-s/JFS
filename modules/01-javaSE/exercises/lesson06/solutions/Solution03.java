package lesson06.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 练习 3 参考答案：受检异常与 try-with-resources
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) {
        // TODO 1：try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader("no_such_file.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("文件读取失败：" + e.getMessage());
        }

        // TODO 2：throws 声明
        try {
            System.out.println(readFirstLine("no_such_file.txt"));
        } catch (IOException e) {
            System.out.println("文件读取失败：" + e.getMessage());
        }
    }

    // 受检异常：方法不处理，就 throws 声明，交给调用者
    static String readFirstLine(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        }
    }
}