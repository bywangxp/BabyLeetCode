package medium.sortColors;

import java.util.Arrays;

/**
 *给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * https://leetcode.cn/problems/sort-colors/description/
 */
public class Solution {

    /**
     * 三个遍历p0，cur，p2
     * p0 左边都是0
     * p0，cur-1 都是 1
     * p2右边都是2
     * 循环不变量
     * [0,p0-1] 0
     * [p0,cur-1] 1
     * [p2+1,nums.length-1]
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {

        /**
         * p0 是下一个0应该放置的位置。
         * p2 是下一个2应该放置的位置。
         * 在当前指针 cur 的左侧，所有的0已经放在正确的位置。
         * 在当前指针 cur 的右侧，所有的2已经放在正确的位置。
         */
        int p0 = 0;
        int cur = 0;
        int p2 = nums.length - 1;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = temp;
                p0++;
                cur++;

            } else if (nums[cur] == 2) {
                int temp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = temp;
                p2--;
            } else {
                cur++;
            }


        }


    }


    /**
     * 自己YY的做法，通过跑全量的case，缝缝补补通过了 ==
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int first = 0;
        int last = nums.length - 1;
        while (first < last) {
            while (first < nums.length && nums[first] == 0) {
                first++;
            }
            if (first >= nums.length) {
                break;
            }
            while (last >= 0 && nums[last] == 2) {
                last--;
            }
            if (last < 0) {
                break;
            }

            if (first >= last) {
                break;
            }
            while (nums[first] == 2) {
                // 交换
                nums[first] = nums[last];
                nums[last] = 2;
                last--;
            }
            while (first < nums.length && nums[first] == 0) {
                first++;
            }
            if (first >= nums.length) {
                break;
            }
            if (last < 0 || first >= last) {
                break;
            }

            while (nums[last] == 0) {
                // 交换
                nums[last] = nums[first];
                nums[first] = 0;
                first++;
            }
            if (first >= nums.length) {
                break;
            }


            if (nums[first] == 1) {
                // 找到后面第一个不等1 的交换
                int temp = first;
                while (temp < last && nums[temp] == 1) {
                    temp++;
                }
                if (temp >= last) {
                    break;
                }


                // 交换
                nums[first] = nums[temp];
                nums[temp] = 1;
            }

        }


    }

    public static void main(String[] args) {
        int[] ints = {2, 0, 0};
        sortColors2(ints);
        System.out.println(Arrays.toString(ints));
    }


}
