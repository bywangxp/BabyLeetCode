package medium.rotatedDigits;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotated-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    // 题目理解错了，把"且和 X 不同的数" 理解为每个位置的数字都跟这个数字不同，那导致以为就在2，5，6，9中选数字
    public static int rotatedDigits(int n) {
        // 3,4,7
        int[] arr = new int[]{2, 5, 6, 9};

        for (int i = 1; i <= arr.length; ++i) {
            backTrace(0, i, new ArrayList<>(), arr, n);
        }


        return result.size();

    }


    /**
     * 回溯
     *
     * @param cur
     * @param arr
     */
    private static void backTrace(int index, int length, List<Integer> cur, int[] arr, int n) {
        // 如果大小 > n 则结束
        // 数字转数字
        Integer targetValue = Integer.valueOf(cur.stream().map(String::valueOf).reduce((a, b) -> a + b).orElse("0"));
        if (targetValue > n) {
            return;
        }

        if (length == 0) {
            result.add(targetValue);
            return;
        }
        for (int i = index; i < arr.length; ++i) {
            cur.add(arr[i]);
            backTrace(index++, length - 1, cur, arr, n);
            cur.remove(cur.size() - 1);
        }


    }

    public static boolean rotatedDigits2(int N) {
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            if (check(i)) {
                count++;
                System.out.println(i); // 打印好数
            }
        }
        System.out.println("Total good numbers: " + count); // 打印好数的总数
        return false;
    }

    public static boolean check(int N) {
        boolean validFound = false;
        while (N > 0) {
            switch (N % 10) {
                case 2:
                case 5:
                case 6:
                case 9:
                    validFound = true;
                    break;
                case 3:
                case 4:
                case 7:
                    return false;
            }
            N /= 10;
        }
        return validFound;
    }

    public static void main(String[] args) {
        //System.out.println(rotatedDigits2(857));
        System.out.println(check(872));
    }
}
