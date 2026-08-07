package lesson11;

/**
 * 练习 1：给 Calculator 写单元测试
 * 配套笔记：notes/11-单元测试与调试.md 第 2 节
 * <p>
 * 先补全 Calculator，再在 Exercise01Test 里写测试。
 */
public class Exercise01 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));   // 5
        System.out.println(calc.divide(10, 2)); // 5.0
    }
}

// TODO：补全 Calculator
// 1. add(int a, int b)：返回 a + b
// 2. subtract(int a, int b)：返回 a - b
// 3. multiply(int a, int b)：返回 a * b
// 4. divide(int a, int b)：返回 double 类型 a / b；b == 0 时
//    throw new ArithmeticException("除数不能为 0")
class Calculator {
    // 你的代码
}