package lesson03.solutions;

/**
 * 练习 1 参考答案：String 与 StringBuilder
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) {
        // TODO 1：统计出现次数
        String text = "hello java, java is fun";
        String key = "java";
        int count = 0;
        int index = text.indexOf(key);
        while (index != -1) {
            count++;
            index = text.indexOf(key, index + key.length());
        }
        System.out.println("java 出现次数：" + count);

        // TODO 2：判断回文
        String word = "上海自来水来自海上";
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(word.equals(reversed) ? "是回文" : "不是回文");

        // TODO 3：解析邮箱
        String email = "zhang.san@example.com";
        String[] parts = email.split("@");
        System.out.println("用户名：" + parts[0] + "，域名：" + parts[1]);

        // TODO 4：敏感词替换
        String sentence = "this is a bad word";
        System.out.println(sentence.replace("bad", "***"));

        // TODO 5：StringBuilder 拼接 1~1000
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            sb.append(i);
        }
        System.out.println(sb.length());
    }
}