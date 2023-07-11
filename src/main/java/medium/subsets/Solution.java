package medium.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Solution {
    static ArrayList<List<Integer>> result = new ArrayList<>();

    /**
     * 回溯的方法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k <= nums.length; k++) {
            getData(0, k, nums, new ArrayList<Integer>());
        }
        return result;


    }

    private static void getData(int index, int length, int[] nums, List<Integer> cur) {
        if (length == 0) {
            // 注意信息：此处采用深拷贝，如果直接result.add(cur) 将导致每次都改变之前add的cur的结果
            result.add(new ArrayList<>(cur));
        }
        for (int i = index; i < nums.length; ++i) {
            cur.add(nums[i]);
            getData(i + 1, length - 1, nums, cur);
            cur.remove(cur.size() - 1);
        }

    }

    /**
     * 迭代的方法，每次都往已有的集合列表中添加新的元素
     *
     * @param nums
     * @return
     */

    private static List<List<Integer>> subsetsOther(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : result) {
                ArrayList<Integer> integers = new ArrayList<>(curr);
                integers.add(num);
                newSubsets.add(integers);



            }
            result.addAll(newSubsets);


        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(subsetsOther(new int[]{1, 2, 3}));
    }


}
