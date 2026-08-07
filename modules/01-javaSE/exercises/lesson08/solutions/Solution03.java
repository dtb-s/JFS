package lesson08.solutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 练习 3 参考答案：线程池
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution03 {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskNo = i;
            pool.execute(() ->
                    System.out.println("任务" + taskNo + " 由 " + Thread.currentThread().getName() + " 执行"));
        }

        Future<Integer> future = pool.submit(() -> 1 + 2 + 3);
        System.out.println("结果：" + future.get());   // 6
        // f.get() 会阻塞当前线程，直到任务执行完拿到结果。

        pool.shutdown();
        System.out.println("主线程结束");
    }
}