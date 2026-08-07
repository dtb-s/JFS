package lesson11;

/**
 * 练习 3：调试练习（本课最重要的练习）
 * 配套笔记：notes/11-单元测试与调试.md 第 3、4 节
 * <p>
 * BuggyCode.findMax 有一个 bug：对"全是负数"的数组返回错误结果。
 * 任务：
 * 1. 先跑 Exercise03Test，观察哪个用例失败
 * 2. 用 IDEA 打开这个文件，在 findMax 里打断点，Debug 运行测试
 * 3. 单步执行，观察 max 变量的变化，定位 bug
 * 4. 修复它，让所有测试通过
 * 5. 把 bug 原因写在注释里
 */
public class Exercise03 {

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{3, 7, 2}));       // 7
        System.out.println(findMax(new int[]{-5, -2, -9}));    // -2（bug：会返回 0）
    }

    // TODO：用调试器找到 bug 并修复
    public static int findMax(int[] nums) {
        int max = 0;              // bug 在这里
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}