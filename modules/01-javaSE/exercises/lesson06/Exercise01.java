package lesson06;

/**
 * 练习 1：try-catch-finally 基础
 * 配套笔记：notes/06-异常.md 第 3 节
 * <p>
 * 题目：补全代码，使输出符合"预期"。
 */
public class Exercise01 {

    public static void main(String[] args) {
        // TODO 1：捕获算术异常
        // try { int r = 10 / 0; } 捕获 ArithmeticException，打印"除零异常"
        // 在 finally 里打印"finally 执行"
        // 预期输出：
        // 除零异常
        // finally 执行

        // TODO 2：数组越界
        // int[] arr = {1, 2, 3}; 访问 arr[5]
        // 捕获 ArrayIndexOutOfBoundsException，打印"下标越界：" + e.getMessage()
        // 预期输出：下标越界：Index 5 out of bounds for length 3

        // TODO 3：多 catch 顺序
        // 把 TODO 1 和 TODO 2 的异常合并到一个 try 里（两个 catch）
        // 注意 catch 顺序：先子类后父类
        // 先触发除零，预期输出：除零异常

        // TODO 4：finally 与 return（经典面试题）
        // 调用 testFinally()，打印返回值，预期：100
        // 然后回答：为什么不是 50？把答案写在注释里
        System.out.println(testFinally());
    }

    // TODO：补全方法，验证 finally 在 return 之后、返回之前执行
    // try 里 return 50；finally 里 return 100
    // 预期：方法返回 100（finally 的 return 覆盖 try 的）
    static int testFinally() {
        // 你的代码
        return 0;
    }
}