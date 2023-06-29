package easy.longestCommonPrefix;

public class BestSolution {
    public static String longestCommonPrefix(String[] strs) {
        // TODO 还有问题待完全解决
        // 找出最长的，然后缩短
        String s = strs[0];
        if (s == null || s.length() == 0) {
            return "";
        }
        while (s.length() > 0) {
            int i = 0;
            for (; i < strs.length; ++i) {
                if (!strs[i].startsWith(s)) {
                    s = s.substring(0, s.length() - 1);
                    break;
                }
            }
            if (i + 1 == strs.length) {
                return s;
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
