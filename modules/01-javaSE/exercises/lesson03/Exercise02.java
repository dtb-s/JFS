package lesson03;

/**
 * 练习 2：包装类
 * 配套笔记：notes/03-核心API.md 第 4 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。
 */
public class Exercise02 {

    public static void main(String[] args) {
        // TODO 1：自动装箱与拆箱
        // 声明 Integer n = 100，int m = n，分别打印 n 和 m
        // 再让 n = n + 1，打印 n，想一想中间发生了什么
        // 预期：100 100 101

        // TODO 2：Integer 缓存陷阱（重点！）
        // Integer a = 127, b = 127, c = 128, d = 128
        // 分别打印 a == b、c == d、c.equals(d)
        // 预期：true false true
        // 在注释里写下你的解释：为什么 a==b 是 true 而 c==d 是 false？

        // TODO 3：字符串与数字转换
        // int n = Integer.parseInt("42")，打印 n + 8，预期：50
        // 用 String.valueOf 把 n 转回字符串，打印它的长度，预期：2
        // （选做）试一下 Integer.parseInt("abc")，观察抛出的异常，然后注释掉

        // TODO 4：Character 统计
        // 统计 "Hello 世界 123" 中字母、数字、空格各有多少个
        // 提示：Character.isLetter / isDigit / isWhitespace，charAt 遍历
        // 预期：字母：7，数字：3，空格：2

        // TODO 5：进制转换
        // 用 Integer.parseInt("1010", 2) 把二进制转十进制，打印，预期：10
        // 用 Integer.toBinaryString(42) 把十进制转二进制，打印，预期：101010
    }
}