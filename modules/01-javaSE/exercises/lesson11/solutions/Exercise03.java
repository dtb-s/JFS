package lesson11.solutions;

/**
 * 练习 3 参考答案：修复后的 BuggyCode
 * 注意：先独立完成练习，再对照这份答案。
 * <p>
 * bug 原因：max 初始化为 0。数组全是负数时，任何负数都不会大于 0，
 * 所以返回了错误的 0。正确做法：初始化为数组第一个元素。
 */
public class Exercise03 {

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{3, 7, 2}));     // 7
        System.out.println(findMax(new int[]{-5, -2, -9}));  // -2
    }

    public static int findMax(int[] nums) {
        int max = nums[0];          // 修复：用第一个元素初始化
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}