package lesson04;

import java.util.HashMap;
import java.util.Map;

/**
 * 练习 3：Map 单词统计（经典题）
 * 配套笔记：notes/04-集合.md 第 5 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。
 */
public class Exercise03 {

    public static void main(String[] args) {
        String text = "hello world hello java java java";

        // TODO 1：统计每个单词出现次数
        // 把 text 按空格 split，用 HashMap<String, Integer> 统计每个单词次数
        // 打印 map，预期：{world=1, java=3, hello=2}（顺序不要求）
        // 提示：getOrDefault(word, 0) + 1 再 put

        // TODO 2：遍历打印
        // 用 entrySet 遍历，打印每个单词和次数，格式：word=count
        // 内容应与 TODO 1 一致（顺序不要求）

        // TODO 3：查找
        // 打印 "java" 的出现次数，预期：3
        // 打印 "python" 的出现次数（不存在），预期：0（用 getOrDefault）

        // TODO 4（选做）：出现最多的单词
        // 遍历 map，找出次数最多的单词并打印
        // 预期：java 3（次数相同取哪个都可以）
    }
}