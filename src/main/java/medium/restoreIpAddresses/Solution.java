package medium.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 */
public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            return result;
        }
        backTrace(result, s, new ArrayList<>(), 0, 0);
        return result;

    }

    private static void backTrace(ArrayList<String> result, String s, ArrayList<String> cur, int count, int index) {
        // 正常3次 把数值组装完成，当到了第四次就直接拿结果了
        if (count == 4 && (index == s.length())) {
            result.add(String.join(".", cur));
            return;
        } else if (count > 4) {
            return;
        }
        for (int i = 1; i <= 3 && index + i <= s.length(); ++i) {

            String data = s.substring(index, index + i);
            if (data.length() > 1 && data.startsWith("0")) {
                continue;
            }
            if (255 < Integer.valueOf(data)) {
                continue;
            }
            cur.add(data);
            backTrace(result, s, cur, count + 1, index + i);
            cur.remove(cur.size() - 1);

        }


    }

    public static void main(String[] args) {
//        System.out.println(255 > Integer.valueOf("1"));
//        System.out.println("123".substring(0,3));
        System.out.println(restoreIpAddresses("10203040"));
//        System.out.println(restoreIpAddresses("1111"));
    }
}
