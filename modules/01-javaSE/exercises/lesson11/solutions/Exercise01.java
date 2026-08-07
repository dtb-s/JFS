package lesson11.solutions;

/**
 * 练习 1 参考答案：Calculator
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Exercise01 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));      // 5
        System.out.println(calc.divide(10, 2));  // 5.0
    }
}

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为 0");
        }
        return (double) a / b;
    }
}