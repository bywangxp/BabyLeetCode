package easy.isPalindrome;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class Solution {
    public static boolean isPalindrome(String s) {

        if(s.length() == 0){
            return true;
        }
        s = s.toLowerCase();

        for (int i = 0, j = s.length() - 1; i < j; ) {
            while (i < j && !whetherChar(s.charAt(i))) {
                i++;
            }
            while (i < j && !whetherChar(s.charAt(j))) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            if(i == j){
                return true;
            }
            i++;
            j--;


        }
        return true;


    }

    public static boolean whetherChar(char t) {

        if ('a' <= t && t <= 'z') {
            return true;
        }
        if ('A' <= t && t <= 'Z') {
            return true;
        }
        if ('0' <= t && t <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("end1");
        System.out.println(isPalindrome("race a car"));
        System.out.println("end2");
        System.out.println(isPalindrome(" "));
        System.out.println("end3");

    }
}
