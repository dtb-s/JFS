package lesson11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 练习 3 测试：BuggyCodeTest
 * <p>
 * 4 个用例，其中负数用例会失败——这就是你要用调试器定位的 bug。
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