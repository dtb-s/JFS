package lesson03;

/**
 * 练习 3：日期时间与 BigDecimal
 * 配套笔记：notes/03-核心API.md 第 5、6 节
 * <p>
 * 题目：补全 main 中的代码，使输出符合"预期"。需要 import 的类自己加。
 */
public class Exercise03 {

    public static void main(String[] args) {
        // TODO 1：计算年龄
        // 出生日期 2000-05-20（LocalDate.of），用 Period.between 计算到今天（LocalDate.now()）的年龄
        // 打印"今年 X 岁"（用 period.getYears()）
        // 预期：今年 26 岁（2026-08-07 时）

        // TODO 2：日期格式化
        // 格式化当前时间 LocalDateTime.now()，格式："yyyy年MM月dd日 HH:mm:ss"
        // 打印结果，观察输出格式是否符合预期（不用核对具体数字）

        // TODO 3：日期运算
        // 打印今天 plusMonths(1) 和 minusDays(100)
        // 再打印 born 和 today 谁在前（isBefore），预期：true（出生日期在今天的日期之前）

        // TODO 4：BigDecimal 精度问题（重点！）
        // 用 double 计算 0.1 + 0.2，打印，观察结果（预期：0.30000000000000004）
        // 用 new BigDecimal("0.1").add(new BigDecimal("0.2"))，打印，预期：0.3
        // 在注释里写下你的解释：为什么 double 会出错？

        // TODO 5：金额计算
        // 单价 19.9，数量 3，用 BigDecimal 计算总价并保留两位小数（setScale + HALF_UP）
        // 预期：总价：59.70
        // 再计算 1 / 3，保留 4 位小数，预期：0.3333
        // 提示：divide 需要指定精度和 RoundingMode，否则除不尽会抛异常
    }
}