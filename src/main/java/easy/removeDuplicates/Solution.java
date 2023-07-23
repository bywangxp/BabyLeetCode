package easy.removeDuplicates;

import java.util.Arrays;

/**
 * Created by bywangxp on 2023/7/23.
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * [0,0,1,1,1,2,2,3,3,4]
     */
    public static int removeDuplicates(int[] nums) {
        int realIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[realIndex] == nums[i]) {
                continue;
            }
            nums[++realIndex] = nums[i];
        }

        return realIndex + 1;

    }

    public static void main(String[] args) {
        //int[] data = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] data = new int[]{1, 2, 3};
        System.out.println(removeDuplicates(data));
        System.out.println(Arrays.toString(data));
    }
}
