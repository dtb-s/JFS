package lesson07.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 练习 2 参考答案：字节流复制文件
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) throws IOException {
        String src = "out/lesson07_data.txt";
        String dst = "out/lesson07_copy.txt";
        new java.io.File("out").mkdirs();

        // TODO 1：缓冲区复制
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dst)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        }

        // TODO 2：验证
        System.out.println(Files.readString(Path.of(dst)));
        System.out.println("size 相等：" + (Files.size(Path.of(src)) == Files.size(Path.of(dst))));

        // TODO 3：Buffered 包装版
        String dst2 = "out/lesson07_copy_buffered.txt";
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst2))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        }
        System.out.println("buffered 复制完成：" + Files.exists(Path.of(dst2)));
    }
}