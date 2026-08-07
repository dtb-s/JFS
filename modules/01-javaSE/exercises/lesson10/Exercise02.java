package lesson10;

/**
 * 练习 2：解析 HTTP 请求（阶段项目热身）
 * 配套笔记：notes/10-网络编程.md 第 4 节
 * <p>
 * 题目：给定一个原始 HTTP 请求字符串，解析出关键信息。
 */
public class Exercise02 {

    public static void main(String[] args) {
        String request = "GET /index.html?name=zhang&page=2 HTTP/1.1\r\n"
                + "Host: localhost:8080\r\n"
                + "User-Agent: curl/8.0\r\n"
                + "Accept: */*\r\n"
                + "\r\n";

        // TODO 1：解析请求行（第一行）
        // 用 split("\r\n") 拆行，取第一行，再用 split(" ") 拆
        // 打印，预期：
        // 方法：GET
        // 路径：/index.html
        // 协议：HTTP/1.1

        // TODO 2：解析查询参数
        // 路径里有 "?name=zhang&page=2"
        // 用 indexOf("?") 找到分隔位置，substring 取出参数部分
        // 再按 "&" 拆成多个参数，按 "=" 拆键值
        // 打印，预期：name=zhang / page=2（每行一个）

        // TODO 3：解析请求头
        // 从第 2 行开始到空行前，每行是 "字段名: 值"
        // 打印所有头，预期：
        // Host: localhost:8080
        // User-Agent: curl/8.0
        // Accept: */*
        // 提示：头部分可以用 substring 从第一个 \r\n\r\n 处截取

        // TODO 4（选做）：找到 Host 并打印
        // 预期：localhost:8080
    }
}