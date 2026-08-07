package lesson10.solutions;

/**
 * 练习 2 参考答案：解析 HTTP 请求
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        String request = "GET /index.html?name=zhang&page=2 HTTP/1.1\r\n"
                + "Host: localhost:8080\r\n"
                + "User-Agent: curl/8.0\r\n"
                + "Accept: */*\r\n"
                + "\r\n";

        // TODO 1：请求行
        String[] lines = request.split("\r\n");
        String[] requestLine = lines[0].split(" ");
        System.out.println("方法：" + requestLine[0]);      // GET
        System.out.println("路径：" + requestLine[1]);      // /index.html?name=zhang&page=2
        System.out.println("协议：" + requestLine[2]);      // HTTP/1.1

        // TODO 2：查询参数
        String pathAndQuery = requestLine[1];
        int q = pathAndQuery.indexOf("?");
        String path = pathAndQuery.substring(0, q);
        String query = pathAndQuery.substring(q + 1);
        System.out.println("纯路径：" + path);              // /index.html
        for (String pair : query.split("&")) {
            System.out.println(pair);                       // name=zhang / page=2
        }

        // TODO 3：请求头
        int headerEnd = request.indexOf("\r\n\r\n");
        String headerPart = request.substring(0, headerEnd);
        String[] headerLines = headerPart.split("\r\n");
        for (int i = 1; i < headerLines.length; i++) {
            System.out.println(headerLines[i]);
        }

        // TODO 4：Host
        for (int i = 1; i < headerLines.length; i++) {
            if (headerLines[i].startsWith("Host:")) {
                System.out.println(headerLines[i].substring(6));
            }
        }
    }
}