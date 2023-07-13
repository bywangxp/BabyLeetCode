package easy;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 */
public class isPalindromeInt {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        if (s.length() == 0) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            if (i == j) {
                return true;
            }
            i++;
            j--;


        }
        return true;


    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));


    }
}
