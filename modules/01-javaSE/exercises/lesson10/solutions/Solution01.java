package lesson10.solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习 1 参考答案：Socket 回声服务器与客户端
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) throws Exception {
        // 启动服务器线程（daemon，主线程结束它就退出）
        Thread serverThread = new Thread(() -> {
            try {
                startServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();
        Thread.sleep(500);

        // 客户端
        try (Socket socket = new Socket("127.0.0.1", 23456)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("hello");
            System.out.println("客户端收到：" + in.readLine());   // HELLO
        }
        // 答案：accept() 要等客户端连接，readLine() 要等数据到达，
        // 不知道什么时候来，所以阻塞等待；这是网络编程的正常行为。
    }

    static void startServer() throws Exception {
        try (ServerSocket server = new ServerSocket(23456)) {
            System.out.println("服务器启动，等待连接...");
            try (Socket socket = server.accept()) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String line = in.readLine();
                System.out.println("服务器收到：" + line);
                out.println(line.toUpperCase());
            }
        }
    }
}