package lesson01.solutions;

/**
 * 练习 2 参考答案：流程控制
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        // TODO 1：判断闰年
        int year = 2024;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " 是闰年");
        } else {
            System.out.println(year + " 不是闰年");
        }

        // TODO 2：9x9 乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }

        // TODO 3：能被 3 或 5 整除的数之和（结果是 2418）
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        // TODO 4：while + break + continue
        // 停在 50：i == 50 时 break，50 本身不打印
        // 10、20、30、40 被 continue 跳过
        int i = 1;
        while (true) {
            if (i == 50) {
                break;
            }
            if (i % 10 == 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

        // TODO 5：质数
        for (int n = 2; n <= 50; n++) {
            boolean isPrime = true;
            for (int j = 2; j < n; j++) {
                if (n % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(n);
            }
        }
    }
}