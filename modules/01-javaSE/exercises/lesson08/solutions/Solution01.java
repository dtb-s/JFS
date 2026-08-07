package lesson08.solutions;

/**
 * 练习 1 参考答案：创建线程的两种方式
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution01 {

    public static void main(String[] args) throws InterruptedException {
        // 方式一：继承 Thread
        MyThread t1 = new MyThread();
        t1.start();

        // 方式二：实现 Runnable
        MyRunnable task = new MyRunnable();
        Thread t2 = new Thread(task);
        t2.start();

        // join：main 等两个线程跑完再继续
        t1.join();
        t2.join();
        System.out.println("main 结束");
        // 不 join 的话，main 可能先打印"main 结束"，子线程后执行完。

        // 选做：直接调 run() 是在 main 线程里执行（输出线程名是 main），没有新线程。
        // t1.run();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("线程：" + getName() + "，" + (i + 1) + " 号任务");
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("线程：" + Thread.currentThread().getName() + "，" + (i == 0 ? "A" : "B") + " 任务");
        }
    }
}