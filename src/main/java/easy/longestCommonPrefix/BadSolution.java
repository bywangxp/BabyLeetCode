package easy.longestCommonPrefix;

/**
 * 执行用时：
 * 8 ms
 * , 在所有 Java 提交中击败了
 * 8.71%
 * 的用户
 * 内存消耗：
 * 39.9 MB
 * , 在所有 Java 提交中击败了
 * 13.10%
 * 的用户
 *
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class BadSolution {
    public static String longestCommonPrefix(String[] strs) {
        String fistStr = strs[0];
        if (fistStr == null || fistStr.length() == 0) {
            return "";
        }
        String result = "";
        outerLoop:
        for (int i = 0; i < fistStr.length(); ++i) {
            char c = fistStr.charAt(i);
            int j = 1;
            for (; j < strs.length; ++j) {
                if (strs[j].length() < i + 1) {
                    break outerLoop;
                }
                if (strs[j].charAt(i) != c) {
                    break outerLoop;
                }
            }
            result += c;


        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
