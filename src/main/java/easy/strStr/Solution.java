package easy.strStr;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/32675/python3-sundayjie-fa-9996-by-tes/
 */
public class Solution {

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); ++i) {
            if(i + needle.length() > haystack.length()){
                return -1;
            }
            String sub = haystack.substring(i,i + needle.length());
            if(sub.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("2342asdfa","a1sdfa"));
        System.out.println("2342asdfa".indexOf("a1sdfa"));
    }
}
