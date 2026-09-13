package lesson11.solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 练习 2 参考答案：StringUtilsTest
 * 注意：先独立完成练习，再对照这份答案。
 * 注意：JUnit 5.12+ 的 @CsvSource 会把"未加引号的空字段"当作 null，
 * 所以空字符串要写成 ''，null 场景用普通 @Test 覆盖。
 */
class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @ParameterizedTest
    @CsvSource({"abc, cba", "a, a", "'', ''"})
    void reverseShouldWork(String input, String expected) {
        assertEquals(expected, utils.reverse(input));
    }

    @Test
    void reverseOfNullShouldReturnNull() {
        assertNull(utils.reverse(null));
    }

    @ParameterizedTest
    @CsvSource({"aba, true", "abc, false", "'', true"})
    void isPalindromeShouldWork(String input, boolean expected) {
        assertEquals(expected, utils.isPalindrome(input));
    }

    @Test
    void nullShouldNotBePalindrome() {
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    void countWordShouldCount() {
        assertEquals(2, utils.countWord("hello world hello", "hello"));
    }

    @Test
    void countWordWithNullWordShouldReturnZero() {
        assertEquals(0, utils.countWord("hello", null));
    }
}