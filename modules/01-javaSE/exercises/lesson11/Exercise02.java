package lesson11;

/**
 * 练习 2：StringUtils 与参数化测试
 * 配套笔记：notes/11-单元测试与调试.md 第 2.5 节
 */
public class Exercise02 {

    public static void main(String[] args) {
        StringUtils utils = new StringUtils();
        System.out.println(utils.reverse("abc"));       // cba
        System.out.println(utils.isPalindrome("aba"));  // true
        System.out.println(utils.countWord("hello world hello", "hello"));  // 2
    }
}

// TODO：补全 StringUtils
// 1. reverse(String s)：返回反转后的字符串（用 StringBuilder）
// 2. isPalindrome(String s)：回文返回 true（注意 null 和空串：null 返回 false，"" 返回 true）
// 3. countWord(String text, String word)：统计 word 在 text 中出现的次数
//    （用 indexOf 循环，参考 lesson03 练习 1；text 或 word 为 null 时返回 0）
class StringUtils {
    // 你的代码
}