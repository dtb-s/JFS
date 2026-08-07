package lesson03;

/**
 * 练习 1：String 与 StringBuilder
 * 配套笔记：notes/03-核心API.md 第 3 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。需要 import 的类自己加。
 */
public class Exercise01 {

    public static void main(String[] args) {
        // TODO 1：统计出现次数
        // 统计 "java" 在 "hello java, java is fun" 中出现的次数
        // 提示：indexOf 循环（找不到返回 -1）
        // 预期：java 出现次数：2

        // TODO 2：判断回文
        // 判断 "上海自来水来自海上" 是否回文（正着读反着读一样）
        // 提示：StringBuilder.reverse() 或双指针
        // 预期：是回文

        // TODO 3：解析邮箱
        // 从 "zhang.san@example.com" 中提取用户名和域名
        // 预期：用户名：zhang.san，域名：example.com
        // 提示：indexOf + substring，或 split

        // TODO 4：敏感词替换
        // 把 "this is a bad word" 中的 "bad" 替换成 "***"
        // 预期：this is a *** word

        // TODO 5：StringBuilder 拼接
        // 用 StringBuilder 把 1~1000 的数字依次拼接成一个字符串（不带分隔符）
        // 打印拼接结果的长度，预期：2893
        // 提示：1~9 是 1 位，10~99 是 2 位，100~999 是 3 位，1000 是 4 位
    }
}