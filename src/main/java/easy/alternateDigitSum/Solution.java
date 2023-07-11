package easy.alternateDigitSum;

/**
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 */
public class Solution {
    public static int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int temp;
            if (i % 2 == 0) {
                temp = 1;
            } else {
                temp = -1;
            }

            result += Integer.valueOf(str.charAt(i) - '0') * temp;


        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(alternateDigitSum(886996));
    }
}
