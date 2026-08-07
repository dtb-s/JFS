package lesson10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习 1：Socket 回声服务器与客户端
 * 配套笔记：notes/10-网络编程.md 第 3 节
 * <p>
 * 题目：补全代码，让服务器把收到的消息转成大写回给客户端。
 * 程序自包含：main 先启动服务器线程，再连接发送消息。
 */
public class Exercise01 {

    public static void main(String[] args) throws Exception {
        // TODO 1：启动服务器（子线程）
        // new Thread(Exercise01::startServer).start()（或 lambda）
        // 然后 Thread.sleep(500) 等服务器就绪

        // TODO 2：客户端连接并发送
        // 用 Socket 连 "127.0.0.1" 的 23456 端口
        // PrintWriter 发送 "hello"
        // BufferedReader 接收回显并打印
        // 预期：客户端收到：HELLO

        // 思考题（写在注释里）：accept() 和 readLine() 为什么是阻塞的？
    }

    // TODO：补全服务器
    // 1. ServerSocket(23456)
    // 2. accept() 拿到连接
    // 3. 读取一行，打印"服务器收到：xxx"
    // 4. 转大写回给客户端
    // 5. 关闭连接（try-with-resources）
    static void startServer() throws Exception {
        // 你的代码
    }
}