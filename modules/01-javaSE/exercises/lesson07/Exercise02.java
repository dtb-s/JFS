package lesson07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 练习 2：字节流复制文件
 * 配套笔记：notes/07-I-O流.md 第 3 节
 * <p>
 * 题目：把 out/lesson07_data.txt 复制成 out/lesson07_copy.txt（源文件由练习 1 生成，
 * 如果没做过练习 1，可以先在 main 里用 Files.writeString 生成一个）。
 */
public class Exercise02 {

    public static void main(String[] args) throws IOException {
        String src = "out/lesson07_data.txt";
        String dst = "out/lesson07_copy.txt";

        // TODO 1：用 FileInputStream / FileOutputStream 复制
        // 用 1024 字节的缓冲区，read(buffer) 返回 -1 结束
        // 注意 out.write(buffer, 0, len) 只写实际读到的长度

        // TODO 2：验证复制结果
        // 用 Files.readString 读取 dst 并打印，应与源文件内容一致
        // 打印两个文件大小（Files.size），预期相等

        // TODO 3（选做）：Buffered 包装版
        // 用 BufferedInputStream / BufferedOutputStream 再复制一遍到
        // out/lesson07_copy_buffered.txt，体会写法区别
    }
}