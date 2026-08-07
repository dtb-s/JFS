package lesson03.solutions;

/**
 * 练习 2 参考答案：包装类
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        // TODO 1：自动装箱与拆箱
        Integer n = 100;      // 装箱：Integer.valueOf(100)
        int m = n;            // 拆箱：n.intValue()
        System.out.println(n);
        System.out.println(m);
        n = n + 1;            // 拆箱计算 + 再装箱，n 指向新对象
        System.out.println(n);

        // TODO 2：Integer 缓存陷阱
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);       // true：valueOf 对 -128~127 复用缓存对象
        System.out.println(c == d);       // false：128 超出缓存范围，各自 new 新对象
        System.out.println(c.equals(d));  // true：equals 比较数值

        // TODO 3：字符串与数字转换
        int num = Integer.parseInt("42");
        System.out.println(num + 8);      // 50
        String str = String.valueOf(num);
        System.out.println(str.length()); // 2
        // int bad = Integer.parseInt("abc");  // NumberFormatException

        // TODO 4：Character 统计
        String s = "Hello 世界 123";
        int letters = 0, digits = 0, spaces = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            }
        }
        System.out.println("字母：" + letters + "，数字：" + digits + "，空格：" + spaces);

        // TODO 5：进制转换
        System.out.println(Integer.parseInt("1010", 2));   // 10
        System.out.println(Integer.toBinaryString(42));    // 101010
    }
}