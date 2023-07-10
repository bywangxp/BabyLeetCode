package easy.searchInsert;



import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Solution {
    /**
     * 闭区间
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        int first = 0;
        int last = nums.length - 1;

        while (first <= last ) {

            int mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return first;



    }

    /**
     * 半开半闭区
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {

        int first = 0;
        int last = nums.length;

        while (first < last ) {

            int mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        return first;


    }

    public static int searchInsert3(int[] nums, int target) {

        int first = -1;
        int last = nums.length;

        while (first+1 < last ) {

            int mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                first = mid ;
            } else {
                last = mid;
            }
        }
        return first +1;


    }

    public static void main(String[] args) {
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 5),2);
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 2),1);
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 7),4);
        assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 0),0);
        System.out.println("over1");


        assertEquals(searchInsert2(new int[]{1, 3, 5, 6}, 5),2);
        assertEquals(searchInsert2(new int[]{1, 3, 5, 6}, 2),1);
        assertEquals(searchInsert2(new int[]{1, 3, 5, 6}, 7),4);
        assertEquals(searchInsert2(new int[]{1, 3, 5, 6}, 0),0);
        System.out.println("over2");

        // 0 , 3   0+3/2 = 1   1+3/2 = 2 33
        assertEquals(searchInsert3(new int[]{1, 3, 5, 6}, 5),2);
        assertEquals(searchInsert3(new int[]{1, 3, 5, 6}, 2),1);
        assertEquals(searchInsert3(new int[]{1, 3, 5, 6}, 7),4);
        assertEquals(searchInsert3(new int[]{1, 3, 5, 6}, 0),0);
        System.out.println("over3");

    }


}
