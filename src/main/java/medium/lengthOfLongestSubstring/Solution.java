package medium.lengthOfLongestSubstring;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author alsoran
 */
public class Solution {
    /**
     * 就是从每个位置作为起点找最长的连续子串，从找找出最大的那个。
     * 双指针，左边表示起点，右边表示不重复的重点。
     * set集合去重，并且可以在循环中复用，不需要每次遍历都从 左边开始，直接从上次遍历的右节点就可以了
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {


        HashSet<Character> set = new HashSet<>();
        int right = 0;
        int maxlength = 0;

        for (int left = 0; left < s.length(); ++left) {

            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }


            if (set.size() > maxlength) {
                maxlength = set.size();
            }

            set.remove(s.charAt(left));

        }


        return maxlength;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
