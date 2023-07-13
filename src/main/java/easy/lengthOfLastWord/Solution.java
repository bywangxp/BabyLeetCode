package easy.lengthOfLastWord;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 *  
 */
public class Solution {
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() != 0) {
                return s1[i].length();
            }
        }
        return 0;

    }

    public static int lengthOfLastWord2(String s) {
        // 倒数第一个不等于i的值
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        if (i < 0) {
            return 0;
        }
        int j = i;
        for (; j >= 0; j--) {
            if (s.charAt(j) == ' ') {

                return i - j;
            }
        }


        return i + 1;


    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord2("luffy is still joyboy"));
        System.out.println(lengthOfLastWord2("Hello World"));
        System.out.println(lengthOfLastWord2(" "));
    }
}
