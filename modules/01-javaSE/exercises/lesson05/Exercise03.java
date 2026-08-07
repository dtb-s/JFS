package lesson05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 练习 3：Lambda、函数式接口与 Stream
 * 配套笔记：notes/05-泛型与Lambda.md 第 5~9 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。
 */
public class Exercise03 {

    public static void main(String[] args) {
        // TODO 1：四个内置函数式接口
        // Predicate<Integer> isEven：判断偶数，test(4) 打印，预期：true
        // Consumer<String> printer：打印字符串，accept("hi") 预期：hi
        // Function<String, Integer> length：取字符串长度，apply("java") 预期：4
        // Supplier<Double> random：返回 Math.random()，get() 打印一个随机数

        // TODO 2：Lambda 排序
        // 用 Lambda 把 List.of("banana", "apple", "cherry") 按长度升序排序
        // 打印，预期：[apple, banana, cherry]（长度 5,6,6，apple 最短）
        // 提示：list.sort((a, b) -> a.length() - b.length())

        // TODO 3：Stream 过滤 + 映射 + 收集
        // 有一个学生名单，过滤出成绩 >= 60 的，收集他们的名字
        // 预期：[张三, 李四, 王五]（赵六 55 分被过滤）
        // 提示：students.stream().filter(...).map(...).collect(Collectors.toList())
        List<Student> students = Arrays.asList(
                new Student("张三", 90),
                new Student("李四", 75),
                new Student("王五", 60),
                new Student("赵六", 55)
        );

        // TODO 4（选做）：Stream 统计
        // 求所有学生分数的总和，预期：280
        // 提示：mapToInt(Student::getScore).sum()
    }
}

class Student {
    private String name;
    private int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}