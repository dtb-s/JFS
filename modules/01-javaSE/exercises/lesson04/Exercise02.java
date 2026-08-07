package lesson04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 练习 2：Set 去重与排序
 * 配套笔记：notes/04-集合.md 第 4 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。
 */
public class Exercise02 {

    public static void main(String[] args) {
        // TODO 1：HashSet 去重
        // 把 List.of(1, 2, 2, 3, 3, 3) 放进 HashSet<Integer>，打印 size()
        // 预期：3（重复的只留一个）

        // TODO 2：TreeSet 排序
        // 创建 TreeSet<Integer>，依次添加 5, 3, 9, 1，直接打印
        // 预期：[1, 3, 5, 9]（自动升序）

        // TODO 3：LinkedHashSet 保持插入顺序
        // 创建 LinkedHashSet<String>，依次添加 "b", "a", "c"，直接打印
        // 预期：[b, a, c]（和插入顺序一致）

        // TODO 4：List 去重（经典用法）
        // 有一个 List.of("a", "b", "a", "c", "b")，用 HashSet 去重后
        // 把结果用 Arrays.sort + toArray 排序后打印
        // 预期：[a, b, c]
        // 提示：new HashSet<>(list) 一步去重；再 new ArrayList<>(set) 转回 List

        // TODO 5（选做）：自定义对象去重
        // 创建两个内容相同的 Student（name 都是 "小明"，age 都是 18）
        // 放进 HashSet，打印 size()，先观察结果，再回答：
        // 为什么没去重？应该重写哪两个方法？（把答案写在注释里）
        // 预期（重写后）：1
    }
}

// TODO（选做）：给 Student 重写 equals 和 hashCode（IDEA 可以自动生成）
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}