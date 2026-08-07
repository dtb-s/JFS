package lesson08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 练习 3：线程池
 * 配套笔记：notes/08-多线程与并发.md 第 7 节
 * <p>
 * 题目：补全代码，使输出符合"预期"。
 */
public class Exercise03 {

    public static void main(String[] args) throws Exception {
        // TODO 1：创建固定 3 线程的线程池
        // ExecutorService pool = Executors.newFixedThreadPool(3);

        // TODO 2：execute 提交 5 个任务
        // 每个任务打印 "任务" + i + " 由 " + Thread.currentThread().getName() + " 执行"
        // 观察：线程名只有 pool-1-thread-1/2/3，说明线程被复用了

        // TODO 3：submit + Future 拿结果（选做）
        // Future<Integer> f = pool.submit(() -> 1 + 2 + 3);
        // 打印 f.get()，预期：6
        // 思考：f.get() 会阻塞等待结果吗？写在注释里

        // TODO 4：关闭线程池
        // 调用 shutdown()，然后打印"主线程结束"
    }
}