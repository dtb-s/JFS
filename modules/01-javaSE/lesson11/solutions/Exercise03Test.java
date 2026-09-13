package lesson11.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 练习 3 参考答案：BuggyCodeTest
 * 注意：先独立完成练习，再对照这份答案。
 */
class Exercise03Test {

    @Test
    void positiveArrayShouldReturnMax() {
        assertEquals(7, Exercise03.findMax(new int[]{3, 7, 2}));
    }

    @Test
    void negativeArrayShouldReturnMax() {
        assertEquals(-2, Exercise03.findMax(new int[]{-5, -2, -9}));
    }

    @Test
    void singleElementArray() {
        assertEquals(5, Exercise03.findMax(new int[]{5}));
    }

    @Test
    void allSameArray() {
        assertEquals(4, Exercise03.findMax(new int[]{4, 4, 4}));
    }
}