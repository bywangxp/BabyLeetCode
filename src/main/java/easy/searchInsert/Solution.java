package easy.searchInsert;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Solution {
    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {

        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 1;
            }
        }
        int mid = nums.length / 2;
        if (nums[mid] == target) {
            // 找到位置了
            return mid;
        }
        if (nums[mid] < target) {

        }


        return 0;
    }

    public int searchInsert(int[] num, int first, int last, int target) {
        return 0;
    }


}
