package lesson11.solutions;

/**
 * 练习 2 参考答案：StringUtils
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Exercise02 {

    public static void main(String[] args) {
        StringUtils utils = new StringUtils();
        System.out.println(utils.reverse("abc"));       // cba
        System.out.println(utils.isPalindrome("aba"));  // true
        System.out.println(utils.countWord("hello world hello", "hello"));  // 2
    }
}

class StringUtils {

    public String reverse(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public int countWord(String text, String word) {
        if (text == null || word == null || word.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = text.indexOf(word);
        while (index != -1) {
            count++;
            index = text.indexOf(word, index + word.length());
        }
        return count;
    }
}