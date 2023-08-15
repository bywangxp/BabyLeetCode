package medium.convert;


/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * <p>
 * ---题目是让Z，实际看起来是N
 */
public class Solution {


    public static String convert(String s, int numRows) {

        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder[] arr = new StringBuilder[numRows];


        for (int i = 0; i < numRows; ++i) {
            arr[i] = new StringBuilder();
        }

        int index = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); ++i) {
            arr[index].append(s.charAt(i));
            if (index == 0) {
                flag = 1;
            } else if (index == numRows - 1) {
                flag = -1;
            }
            index += flag;

        }
        StringBuilder result = new StringBuilder();


        for (StringBuilder sg : arr) {
            result.append(sg);
        }

        return result.toString();


    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

}
