package lesson01.solutions;

/**
 * 练习 3 参考答案：数组
 * 注意：先独立完成练习，再对照这份答案。
 */
import java.util.Arrays;

public class Solution03 {

    public static void main(String[] args) {
        int[] scores = {78, 92, 85, 60, 99, 45, 88, 57};

        // TODO 1：最高分、最低分、平均分
        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int s : scores) {
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }
            sum += s;
        }
        double avg = (double) sum / scores.length;
        System.out.println("最高分 " + max);
        System.out.println("最低分 " + min);
        System.out.printf("平均分 %.2f%n", avg);

        // TODO 2：反转数组（存入新数组，不修改 scores）
        int[] reversed = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            reversed[i] = scores[scores.length - 1 - i];
        }
        System.out.println(Arrays.toString(reversed));

        // TODO 3：查找 85
        int target = 85;
        int index = -1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println(index);

        // TODO 4：统计及格人数
        int pass = 0;
        for (int s : scores) {
            if (s >= 60) {
                pass++;
            }
        }
        System.out.print("及格 " + pass + " 人，不及格：");
        for (int s : scores) {
            if (s < 60) {
                System.out.print(s + " ");
            }
        }
        System.out.println();

        // TODO 5：二维数组
        int[][] classScores = {
            {90, 80, 70, 60},
            {85, 75, 65, 55},
            {100, 95, 90, 85}
        };
        for (int i = 0; i < classScores.length; i++) {
            int total = 0;
            for (int s : classScores[i]) {
                total += s;
            }
            double avg2 = (double) total / classScores[i].length;
            System.out.println("班级 " + (i + 1) + " 平均分 " + avg2);
        }
    }
}