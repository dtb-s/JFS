package lesson08;

/**
 * 练习 1：创建线程的两种方式
 * 配套笔记：notes/08-多线程与并发.md 第 2、3 节
 * <p>
 * 题目：补全代码，使输出符合"预期"。
 */
public class Exercise01 {

    public static void main(String[] args) throws InterruptedException {
        // TODO 1：方式一：继承 Thread
        // 创建 MyThread 并 start()，预期打印：
        // 线程：Thread-0，1 号任务
        // 线程：Thread-0，2 号任务

        // TODO 2：方式二：实现 Runnable
        // 创建 MyRunnable，包进 Thread 并 start()
        // 预期打印：
        // 线程：Thread-1，A 任务
        // 线程：Thread-1，B 任务

        // TODO 3：join 等待
        // 在 main 里调用 t1.join() 和 t2.join()（抛 InterruptedException）
        // 然后打印"main 结束"，预期："main 结束"在最后输出
        // 思考：不 join 会怎么样？把答案写在注释里

        // TODO 4（选做）：start vs run
        // 直接调用 t1.run()，观察输出里的线程名
        // 把结论写在注释里：run() 是哪个线程在执行？
    }
}

// TODO：MyThread 继承 Thread
// 重写 run()：循环 2 次，每次打印 "线程：" + getName() + "，" + (i+1) + " 号任务"
class MyThread {
    // 你的代码
}

// TODO：MyRunnable 实现 Runnable
// 重写 run()：循环 2 次，每次打印 "线程：" + Thread.currentThread().getName() + "，" + (i == 0 ? "A" : "B") + " 任务"
class MyRunnable {
    // 你的代码
}