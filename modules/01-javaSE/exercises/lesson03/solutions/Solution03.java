package lesson03.solutions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 练习 3 参考答案：日期时间与 BigDecimal
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) {
        // TODO 1：计算年龄
        LocalDate born = LocalDate.of(2000, 5, 20);
        LocalDate today = LocalDate.now();
        Period period = Period.between(born, today);
        System.out.println("今年 " + period.getYears() + " 岁");

        // TODO 2：日期格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(LocalDateTime.now().format(formatter));

        // TODO 3：日期运算
        System.out.println(today.plusMonths(1));
        System.out.println(today.minusDays(100));
        System.out.println(born.isBefore(today));   // true

        // TODO 4：BigDecimal 精度问题
        System.out.println(0.1 + 0.2);   // 0.30000000000000004
        BigDecimal sum = new BigDecimal("0.1").add(new BigDecimal("0.2"));
        System.out.println(sum);         // 0.3

        // TODO 5：金额计算
        BigDecimal price = new BigDecimal("19.9");
        BigDecimal total = price.multiply(new BigDecimal("3")).setScale(2, RoundingMode.HALF_UP);
        System.out.println("总价：" + total);

        BigDecimal oneThird = new BigDecimal("1").divide(new BigDecimal("3"), 4, RoundingMode.HALF_UP);
        System.out.println(oneThird);    // 0.3333
    }
}