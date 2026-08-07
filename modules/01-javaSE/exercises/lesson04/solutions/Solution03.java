package lesson04.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 练习 3 参考答案：Map 单词统计
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) {
        String text = "hello world hello java java java";

        // TODO 1：统计
        Map<String, Integer> map = new HashMap<>();
        for (String word : text.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);   // {world=1, java=3, hello=2}（顺序不要求）

        // TODO 2：entrySet 遍历
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

        // TODO 3：查找
        System.out.println(map.getOrDefault("java", 0));    // 3
        System.out.println(map.getOrDefault("python", 0));  // 0

        // TODO 4：出现最多的单词
        String maxWord = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > maxCount) {
                maxWord = e.getKey();
                maxCount = e.getValue();
            }
        }
        System.out.println(maxWord + " " + maxCount);   // java 3
    }
}