package lesson05.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 练习 3 参考答案：Lambda、函数式接口与 Stream
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) {
        // TODO 1：四个内置函数式接口
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4));            // true

        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("hi");                          // hi

        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("java"));      // 4

        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        // TODO 2：Lambda 排序
        List<String> fruits = Arrays.asList("banana", "apple", "cherry");
        fruits.sort((a, b) -> a.length() - b.length());
        System.out.println(fruits);                    // [apple, banana, cherry]

        // TODO 3：Stream 过滤 + 映射 + 收集
        List<Student> students = Arrays.asList(
                new Student("张三", 90),
                new Student("李四", 75),
                new Student("王五", 60),
                new Student("赵六", 55)
        );
        List<String> names = students.stream()
                .filter(s -> s.getScore() >= 60)
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(names);                     // [张三, 李四, 王五]

        // TODO 4：Stream 统计
        int sum = students.stream().mapToInt(Student::getScore).sum();
        System.out.println(sum);                       // 280
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
}