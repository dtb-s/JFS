package lesson04;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习 1：List
 * 配套笔记：notes/04-集合.md 第 3 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。
 */
public class Exercise01 {

    public static void main(String[] args) {
        // TODO 1：创建 ArrayList<Integer> scores，依次添加 78, 92, 85, 60, 99
        List<Integer> scores = new ArrayList<>();

        // TODO 2：添加和删除
        // 在末尾添加 88，打印 size()，预期：6
        // 按下标删除第 3 个元素（60），打印删除后 size()，预期：5
        // 按内容删除 88，打印 size()，预期：4

        // TODO 3：查询
        // 打印是否包含 99，预期：true
        // 打印 92 的下标，预期：1
        // 打印第 0 个元素，预期：78

        // TODO 4：修改
        // 把下标 0 的元素改成 80，打印 get(0)，预期：80

        // TODO 5：排序和反转
        // 用 Collections.sort 升序打印，预期：[80, 85, 92, 99]
        // 用 Collections.reverse 反转打印，预期：[99, 92, 85, 80]
        // 需要 import java.util.Collections

        // TODO 6（选做）：遍历求和
        // 用 for-each 求和并打印，预期：356（99+92+85+80）
    }
}