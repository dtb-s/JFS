package lesson07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 练习 1：字符流读写文本
 * 配套笔记：notes/07-I-O流.md 第 4 节
 * <p>
 * 题目：程序先自己写一个文本文件，再读回来处理（自包含，不依赖外部文件）。
 */
public class Exercise01 {

    public static void main(String[] args) throws IOException {
        String path = "out/lesson07_data.txt";

        // TODO 1：写入文件
        // 用 BufferedWriter + FileWriter 写入 3 行：
        //   java is fun
        //   hello world
        //   java is powerful
        // 每行写完要 newLine()，用 try-with-resources
        // 提示：先确保 out 目录存在：new File("out").mkdirs()

        // TODO 2：按行读取并统计
        // 用 BufferedReader + FileReader 读回文件
        // 打印总行数，预期：3
        // 统计包含 "java" 的行数，预期：2
        // 提示：line.contains("java")，try-with-resources

        // TODO 3（选做）：加行号重写
        // 再读一遍，把每行前面加 "1: " "2: " 后写回新文件 out/lesson07_numbered.txt
        // 打印新文件内容，预期：
        // 1: java is fun
        // 2: hello world
        // 3: java is powerful
    }
}