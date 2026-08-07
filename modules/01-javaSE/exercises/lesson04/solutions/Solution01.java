package lesson04.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 练习 1 参考答案：List
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) {
        // TODO 1
        List<Integer> scores = new ArrayList<>();
        scores.add(78);
        scores.add(92);
        scores.add(85);
        scores.add(60);
        scores.add(99);

        // TODO 2：添加和删除
        scores.add(88);
        System.out.println(scores.size());       // 6
        scores.remove(3);                        // 删 60
        System.out.println(scores.size());       // 5
        scores.remove(Integer.valueOf(88));      // 按内容删（包装类！）
        System.out.println(scores.size());       // 4

        // TODO 3：查询
        System.out.println(scores.contains(99)); // true
        System.out.println(scores.indexOf(92));  // 1
        System.out.println(scores.get(0));       // 78

        // TODO 4：修改
        scores.set(0, 80);
        System.out.println(scores.get(0));       // 80

        // TODO 5：排序和反转
        Collections.sort(scores);
        System.out.println(scores);              // [80, 85, 92, 99]
        Collections.reverse(scores);
        System.out.println(scores);              // [99, 92, 85, 80]

        // TODO 6：遍历求和
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        System.out.println(sum);                 // 356
    }
}