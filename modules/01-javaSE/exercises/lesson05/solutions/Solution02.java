package lesson05.solutions;

import java.util.List;

/**
 * 练习 2 参考答案：泛型方法与通配符
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        System.out.println(Utils.first(List.of("a", "b", "c")));  // a
        System.out.println(Utils.first(List.of(1, 2, 3)));        // 1

        Utils.printAll(List.of("a", "b", "c"));
        Utils.printAll(List.of(1, 2, 3));

        System.out.println(Utils.max(List.of(3, 7, 2)));          // 7

        System.out.println(Utils.sumNumber(List.of(1.5, 2.5)));   // 4.0
    }
}

class Utils {

    public static <T> T first(List<T> list) {
        return list.get(0);
    }

    public static void printAll(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static double sumNumber(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}