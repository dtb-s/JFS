package lesson07.solutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 练习 1 参考答案：字符流读写文本
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) throws IOException {
        String path = "out/lesson07_data.txt";
        new File("out").mkdirs();

        // TODO 1：写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("java is fun");
            writer.newLine();
            writer.write("hello world");
            writer.newLine();
            writer.write("java is powerful");
            writer.newLine();
        }

        // TODO 2：按行读取并统计
        int lines = 0;
        int javaLines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                if (line.contains("java")) {
                    javaLines++;
                }
            }
        }
        System.out.println("总行数：" + lines);       // 3
        System.out.println("含 java 的行数：" + javaLines);   // 2

        // TODO 3：加行号重写
        String numbered = "out/lesson07_numbered.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(numbered))) {
            String line;
            int n = 0;
            while ((line = reader.readLine()) != null) {
                n++;
                writer.write(n + ": " + line);
                writer.newLine();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(numbered))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}