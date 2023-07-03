package medium.reverse;


import java.util.Stack;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */

public class Solution {
    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 5.06%
     * 的用户
     * 内存消耗：
     * 39.4 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     *
     * @param x
     * @return
     */
    public static int reverseMy(int x) {
        int start = 0;
        String result = "";

        if (x < 0) {
            start = 1;
            result += "-";
        }

        String str = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (; start < str.length(); ++start) {
            stack.add(str.charAt(start));
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        Long aLong = Long.valueOf(result);
        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.valueOf(result);
    }

    /**
     * int 类型
     * 最大的整数 2^32 -1 :2,147,483,647
     * 最小的整数 - 2^32  : - 2,147,483,648
     * 取最后一个数字的方法  取模
     *
     * res = x / 10
     * 翻转后的数字: res * 10 +
     * 翻转的数字
     *
     * 为了防止数字越界，在 转化为最终的数字之前就要check
     * 当>0 ,   x>2,147,483,64 || x == 2,147,483,64  余数 > 7
     * 当<0 ,   x<-2,147,483,64 || x == -2,147,483,64  余数 > 8
     *
     *
     *
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int temp ;
        int result = 0;
        while( x != 0){
            temp = x % 10;
            x = x / 10;
            if (result >214748364 || (result == 214748364 && temp > 7)){
                return 0;
            }
            if (result <-214748364 || (result == -214748364 && temp > 8)){
                return 0;
            }

            result =  result * 10 + temp;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(12123));
        System.out.println(reverse(0));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }


}
