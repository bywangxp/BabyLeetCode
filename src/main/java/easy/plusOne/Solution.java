package easy.plusOne;

import java.util.Arrays;

public class Solution {
    // 4+8 = 12  12/ 10 = 1    12%10  =2 【当前值】
    // 4+2 =6    6/10 = 0      6%10 = 6【当前值】

    /**
     * 思想就是看后面数字是不是9
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int preNum = 1;
        boolean alwaysNine = true;

        for (int i = digits.length - 1; (i >= 0 && preNum == 1); --i) {
            if (digits[i] != 9) {
                alwaysNine = false;
            }
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                preNum = 0;
            }


        }
        if (!alwaysNine) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }


}
