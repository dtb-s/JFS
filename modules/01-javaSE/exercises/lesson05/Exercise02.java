package lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 练习 2：泛型方法与通配符
 * 配套笔记：notes/05-泛型与Lambda.md 第 3、4 节
 * <p>
 * 题目：补全 Utils 类中的泛型方法，并在 main 中测试。
 */
public class Exercise02 {

    public static void main(String[] args) {
        // TODO 1：调用 Utils.first 取第一个元素
        // List.of("a", "b", "c") → 打印，预期：a
        // List.of(1, 2, 3) → 打印，预期：1
        // 注意：两个调用返回类型不同，但都不需要强转

        // TODO 2：调用 Utils.printAll 打印
        // 传 List<String> 和 List<Integer> 各一次
        // 预期：a b c（每行一个）和 1 2 3

        // TODO 3：调用 Utils.max 求最大值
        // List.of(3, 7, 2) → 打印，预期：7
        // 提示：Integer 实现了 Comparable

        // TODO 4（选做）：Utils.sumNumber
        // 传 List.of(1.5, 2.5) → 打印，预期：4.0
        // 提示：? extends Number + doubleValue()
    }
}

class Utils {
    // TODO：泛型方法 first：返回 List<T> 的第一个元素
    // 签名：public static <T> T first(List<T> list)

    // TODO：printAll：接受任意类型 List 并逐个打印
    // 签名：public static void printAll(List<?> list)

    // TODO：max：返回 List<T> 的最大值
    // 提示：T 要能比较，需要 <T extends Comparable<T>>，用 compareTo
    // 签名：public static <T extends Comparable<T>> T max(List<T> list)

    // TODO（选做）：sumNumber：把 List<? extends Number> 转成 double 求和
    // 提示：Number.doubleValue()，返回值 double
}