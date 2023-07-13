package medium.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class Solution {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        getData(1, n, k, new ArrayList<Integer>());
        return result;

    }

    private static void getData(int index, int n, int length, List<Integer> cur) {
        if (length == 0) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = index; i <= n; ++i) {
            cur.add(i);
            getData(i + 1, n, length - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(1,0));
    }
}
