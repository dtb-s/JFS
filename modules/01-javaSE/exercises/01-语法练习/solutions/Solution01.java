/**
 * 练习 1 参考答案：变量与数据类型
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) {
        // TODO 1：声明变量
        int age = 25;
        double height = 1.75;
        char gender = 'M';
        boolean isStudent = true;

        System.out.println(age);
        System.out.println(height);
        System.out.println(gender);
        System.out.println(isStudent);

        // TODO 2：强制类型转换
        // 结果是 1：强制转换直接砍掉小数部分，不是四舍五入
        int h = (int) height;
        System.out.println(h);

        // TODO 3：整数除法陷阱
        // 9 / 5 是整数除法，结果是 1；9.0 / 5 有浮点数参与，结果是 1.8
        System.out.println(9 / 5);
        System.out.println(9.0 / 5);

        // TODO 4：字符串拼接
        // 遇到字符串后，+ 变成拼接；从左往右算
        System.out.println("1 + 2 = " + 1 + 2);   // 1 + 2 = 12
        System.out.println(1 + 2 + " = 3");       // 3 = 3

        // TODO 5：常量与圆面积
        final double PI = 3.14159;
        double radius = 5;
        double area = PI * radius * radius;
        System.out.println(area);   // 78.53975

        // TODO 6：华氏度转换
        double celsius = 37;
        double fahrenheit = celsius * 9.0 / 5 + 32;
        System.out.println(fahrenheit);   // 98.6
    }
}