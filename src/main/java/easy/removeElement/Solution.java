package easy.removeElement;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {
    public static int removeElement(int[] nums, int val) {

        int first = 0;
        int last = nums.length - 1;
        while (first < last && last > 0 && first < (nums.length - 1)) {
            if (nums[first] != val) {
                first = first + 1;
                continue;
            }
            if (nums[last] == val) {
                last = last - 1;
                continue;
            }

            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == val) {
                break;
            }
        }

        System.out.println(Arrays.toString(nums));
        return last;


    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println("----");
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println("----");
        System.out.println(removeElement(new int[]{2, 2, 2, 2}, 2));
        System.out.println("----");

        System.out.println(removeElement(new int[]{}, 2));
        System.out.println("----00");

        System.out.println(removeElement(new int[]{2}, 3));
    }


}
