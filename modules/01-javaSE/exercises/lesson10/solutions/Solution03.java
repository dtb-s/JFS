package lesson10.solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习 3 参考答案（选做）：多客户端服务器
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) throws Exception {
        // 服务器：每个连接一个线程
        Thread server = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(23457)) {
                int n = 0;
                while (true) {
                    Socket socket = serverSocket.accept();
                    n++;
                    final int clientNo = n;
                    new Thread(() -> handle(socket, clientNo)).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        server.setDaemon(true);
        server.start();
        Thread.sleep(500);

        // 两个客户端线程
        new Thread(() -> client("hello-1")).start();
        new Thread(() -> client("hello-2")).start();
        Thread.sleep(2000);
    }

    static void handle(Socket socket, int clientNo) {
        try (socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String line = in.readLine();
            out.println("你好，客户端" + clientNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void client(String msg) {
        try (Socket socket = new Socket("127.0.0.1", 23457)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(msg);
            System.out.println(msg + " 收到：" + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}