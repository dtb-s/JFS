package lesson11.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 练习 1 参考答案：CalculatorTest
 * 注意：先独立完成练习，再对照这份答案。
 */
class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void addShouldReturnSum() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtractShouldReturnDifference() {
        assertEquals(6, calc.subtract(10, 4));
    }

    @Test
    void multiplyShouldReturnProduct() {
        assertEquals(12, calc.multiply(3, 4));
    }

    @Test
    void divideShouldReturnQuotient() {
        assertEquals(2.5, calc.divide(10, 4));
    }

    @Test
    void divideByZeroShouldThrow() {
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
    }
}