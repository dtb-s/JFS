package lesson04.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 练习 2 参考答案：Set 去重与排序
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        // TODO 1：HashSet 去重
        Set<Integer> set = new HashSet<>(List.of(1, 2, 2, 3, 3, 3));
        System.out.println(set.size());   // 3

        // TODO 2：TreeSet 排序
        Set<Integer> tree = new TreeSet<>();
        tree.add(5);
        tree.add(3);
        tree.add(9);
        tree.add(1);
        System.out.println(tree);         // [1, 3, 5, 9]

        // TODO 3：LinkedHashSet 保持插入顺序
        Set<String> linked = new LinkedHashSet<>();
        linked.add("b");
        linked.add("a");
        linked.add("c");
        System.out.println(linked);       // [b, a, c]

        // TODO 4：List 去重
        List<String> list = List.of("a", "b", "a", "c", "b");
        List<String> dedup = new ArrayList<>(new HashSet<>(list));
        String[] arr = dedup.toArray(new String[0]);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));   // [a, b, c]

        // TODO 5：自定义对象去重
        Set<Student> students = new HashSet<>();
        students.add(new Student("小明", 18));
        students.add(new Student("小明", 18));
        System.out.println(students.size());   // 1（重写 equals + hashCode 后）
        // 没重写前是 2：HashSet 先按 hashCode 找桶，再按 equals 判断重复。
        // 默认的 equals/hashCode 按地址比较，两个对象地址不同，所以不去重。
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return age == s.age && name.equals(s.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + age;
    }
}