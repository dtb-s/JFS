/**
 * 练习 1：变量与数据类型
 * 配套笔记：notes/01-语言基础.md 第 3、4 节
 *
 * 题目要求：补全 TODO 部分，使程序输出和"预期"一致。
 * 完成后，在代码旁用注释写下你的理解。
 */
public class Exercise01 {

    public static void main(String[] args) {
        // TODO 1：声明变量
        // 声明一个 int 变量 age，值为 25
        // 声明一个 double 变量 height，值为 1.75
        // 声明一个 char 变量 gender，值为 'M'
        // 声明一个 boolean 变量 isStudent，值为 true

        int age = 25;
        double height = 1.75;
        char gender = 'M';
        boolean isStudent = true;

        System.out.println(age);        // 预期：25
        System.out.println(height);     // 预期：1.75
        System.out.println(gender);     // 预期：M
        System.out.println(isStudent);  // 预期：true

        // TODO 2：强制类型转换
        // 把 height 强制转换成 int，赋值给变量 h，然后打印 h
        // 思考：结果是 1 还是 2？为什么？
        int h = (int) height;
        System.out.println(h);

        // TODO 3：整数除法陷阱
        // 分别打印 9 / 5 和 9.0 / 5 的结果
        // 思考：为什么结果不一样？
        System.out.println(9 / 5);
        System.out.println(9.0 / 5);

        // TODO 4：字符串拼接
        // 打印 "1 + 2 = " + 1 + 2 和 1 + 2 + " = 3"
        // 思考：两次结果有什么不同？为什么？

        // TODO 5：常量与圆面积
        // 用 final 定义常量 PI = 3.14159
        // 计算半径为 5 的圆面积（面积 = PI * 半径 * 半径），打印结果
        // 预期：78.53975

        // TODO 6（选做）：华氏度转换
        // 摄氏 37 度，华氏度 = 摄氏 * 9 / 5 + 32
        // 用 double 计算并打印，预期：98.6
        // 提示：注意整数除法陷阱，试试 9.0 / 5
    }
}