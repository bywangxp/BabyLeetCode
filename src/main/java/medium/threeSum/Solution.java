package medium.threeSum;

import java.util.*;

/**
 *
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 */
public class Solution {
    /**
     * 第一个元素保持不动，剩下两个元素使用指针的方式 从前往后寻找
     *
     * @param nums
     * @return
     */
    // -1, 0, 1, 2, -1, -4
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            // 第一个元素相等的不用继续了
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    // 第2个元素相等的不用继续了
                    while(left  < right && nums[left] == nums[left +1 ]){
                        left ++;
                    }
                    // 第3个元素相等的不用继续了
                    while(left  < right && nums[right] == nums[right -1 ]){
                        right --;
                    }
                    left ++;
                    right --;



                }
                if (left  < right && nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (left  < right &&nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }
                ;


            }


        }


        return result;

    }

    // 暴力求教   超出时间限制
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();

        }
        List result = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                for (int k = i + 2; k < nums.length; ++k) {
                    if (i != j && i != k && j != k && (nums[i] + nums[j] + nums[k]) == 0) {
                        int[] temp = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(temp);
                        String tempString = temp[0] + "_" + temp[1] + "_" + temp[2];
                        if (set.contains(tempString)) {
                            continue;
                        }
                        set.add(tempString);

                        List<Integer> list = new ArrayList<>();
                        // 三个元素排序一下，单独放在一个字符串里，通过这个

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                    }
                }
            }
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum2(new int[]{0, 1, 1}));
        System.out.println(threeSum2(new int[]{0, 0, 0}));
    }
}
