package lesson08;

/**
 * 练习 2：线程安全问题（卖票）
 * 配套笔记：notes/08-多线程与并发.md 第 4 节
 * <p>
 * 题目：补全 TicketWindow，让 3 个窗口卖 100 张票不超卖。
 */
public class Exercise02 {

    public static void main(String[] args) throws InterruptedException {
        // TODO 1：创建 TicketWindow（共享同一个实例！），开 3 个线程
        // 每个线程取名"窗口1"~"窗口3"
        // 预期：三个窗口共卖出 100 张票，最后剩余 0 张
        // 提示：Thread t = new Thread(window, "窗口1")

        // TODO 2：join 等待所有窗口结束，然后打印剩余票数
        // 预期：剩余票数：0

        // 思考题（写在注释里）：
        // 如果不加 synchronized，会出现什么问题？为什么？
    }
}

// TODO：补全 TicketWindow 实现 Runnable
// 1. 私有字段 int tickets = 100
// 2. sell() 方法：tickets > 0 时打印窗口名 + "卖出第" + tickets + "张票"，然后 tickets--
//    给 sell() 加 synchronized（同步方法）
// 3. run() 里循环调用 sell()，直到没票
// 4. getRemaining() 返回剩余票数
class TicketWindow {
    // 你的代码
}