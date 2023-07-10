package medium.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Solution {
    static ArrayList<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <= nums.length; ++i) {
            backTrack(0, i, new ArrayList<>(), nums);
        }
        return result;


    }

    private static void backTrack(int start, int k, List<Integer> cur, int[] nums) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            backTrack(i + 1, k - 1, cur, nums);
            cur.remove(cur.size() - 1);

        }


    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }


}
