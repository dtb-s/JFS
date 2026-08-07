package lesson06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 练习 3：受检异常与 try-with-resources
 * 配套笔记：notes/06-异常.md 第 4、5 节
 * <p>
 * 题目：补全代码，使输出符合"预期"。
 * 注意：练习不需要真实文件——用一个不存在的路径演示异常处理。
 */
public class Exercise03 {

    public static void main(String[] args) {
        // TODO 1：try-with-resources 读文件
        // 用 try (BufferedReader reader = new BufferedReader(new FileReader("no_such_file.txt")))
        // 捕获 IOException，打印"文件读取失败：" + e.getMessage()
        // 预期：文件读取失败：no_such_file.txt（系统找不到指定的文件。）
        // 思考：为什么这里必须处理异常？（受检异常，不处理编译不过）

        // TODO 2：throws 声明（选做）
        // 把 TODO 1 的读取逻辑抽到方法 readFirstLine(String path) 里
        // 方法声明 throws IOException，不捕获
        // 在 main 里调用时用 try-catch 处理
        // 预期输出同上
    }
}