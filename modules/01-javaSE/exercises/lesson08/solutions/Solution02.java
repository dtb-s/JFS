package lesson08.solutions;

/**
 * 练习 2 参考答案：线程安全问题（卖票）
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) throws InterruptedException {
        TicketWindow window = new TicketWindow();

        Thread t1 = new Thread(window, "窗口1");
        Thread t2 = new Thread(window, "窗口2");
        Thread t3 = new Thread(window, "窗口3");
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("剩余票数：" + window.getRemaining());
        // 答案：不加 synchronized，多个线程可能同时通过 tickets > 0 判断，
        // 导致同一张票卖两次（超卖）或卖成负数。synchronized 保证同一时刻
        // 只有一个线程进入 sell()，tickets 的判断和自减是原子的。
    }
}

class TicketWindow implements Runnable {
    private int tickets = 100;

    public synchronized void sell() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖出第 " + tickets + " 张票");
            tickets--;
        }
    }

    @Override
    public void run() {
        while (tickets > 0) {
            sell();
        }
    }

    public int getRemaining() {
        return tickets;
    }
}