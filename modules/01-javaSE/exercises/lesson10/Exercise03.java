package lesson10;

/**
 * 练习 3（选做）：多客户端服务器
 * 配套笔记：notes/10-网络编程.md 第 3 节
 * <p>
 * 题目：让服务器能同时服务多个客户端（每个连接一个线程）。
 * 预期：两个客户端都能收到自己的回显。
 */
public class Exercise03 {

    public static void main(String[] args) throws Exception {
        // TODO 1：服务器：ServerSocket(23457)，死循环 accept()
        // 每个连接 new Thread(() -> handle(socket)).start()
        // handle：读取一行，回显"你好，客户端N"（用连接序号）

        // TODO 2：客户端：开两个线程，各连一次发送 "hello-1" / "hello-2"
        // 各自打印收到的回显

        // 提示：服务器线程设为 daemon，程序才能退出
        // 预期输出包含：你好，客户端1 / 你好，客户端2（顺序不要求）
    }
}