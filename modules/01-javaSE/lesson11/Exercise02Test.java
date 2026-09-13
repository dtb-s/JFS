package lesson11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 练习 2 测试：StringUtilsTest
 * <p>
 * TODO：
 * 1. 用 @ParameterizedTest + @CsvSource 给 reverse 写 3 组用例：
 *    "abc" → "cba"、"a" → "a"、"" → ""
 * 2. 用 @ParameterizedTest + @CsvSource 给 isPalindrome 写 4 组用例：
 *    "aba" → true、"abc" → false、"" → true、null → false
 *    （注意 null 在 @CsvSource 里用空值：{null 需要特殊写法，见下）
 * 3. 给 countWord 写 2 个 @Test：
 *    countWord("hello world hello", "hello") == 2
 *    countWord("hello", null) == 0
 */
class StringUtilsTest {

    // 提示：@CsvSource 传 null 的写法是 {nullValue = "NULL"}，
    // 或用两个普通 @Test 代替参数化测试来覆盖 null 场景，二选一即可。

    // 你的代码
}