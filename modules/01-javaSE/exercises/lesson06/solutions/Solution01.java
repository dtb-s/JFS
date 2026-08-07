package lesson06.solutions;

/**
 * 练习 1 参考答案：try-catch-finally 基础
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) {
        // TODO 1：捕获算术异常
        try {
            int r = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("除零异常");
        } finally {
            System.out.println("finally 执行");
        }

        // TODO 2：数组越界
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("下标越界：" + e.getMessage());
        }

        // TODO 3：多 catch（先子类后父类）
        try {
            int r = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("除零异常");
        } catch (RuntimeException e) {
            System.out.println("运行时异常");
        }

        // TODO 4：finally 与 return
        System.out.println(testFinally());   // 100
        // 答案：finally 在 return 之前执行，如果 finally 里有 return，
        // 会覆盖 try 里的 return。所以方法返回 100。
    }

    static int testFinally() {
        try {
            return 50;
        } finally {
            return 100;
        }
    }
}