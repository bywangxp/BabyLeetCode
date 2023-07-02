package easy.longestCommonPrefix;

public class BestSolution {
    /**
     * 看了别人的思路做的：
     * 找到最长的，然后随机选一个作为初始字符串，每个字符串对比这个结果，一直缩短到公共的部分，一直下去
     *
     * @param strs
     * @return
     */

    public static String longestCommonPrefix(String[] strs) {

        String s = strs[0];
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < strs.length; ++i) {
            while (!strs[i].startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }


        return s;
    }

    public String longestCommonPrefixGoodCase(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) return "";
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
//        String str = "2323";
//        System.out.println(str.substring(0,3));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
