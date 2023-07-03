package hard.findMedianSortedArrays;

import java.util.Arrays;

/**
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 中位数是统计学中的一个重要概念，它是一组数据排序后处于中间位置的数。对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个（对于奇数个数）或两个（对于偶数个数，取两者平均值）作为中位数。
 * <p>
 * 举例来说，如果我们有一个包含7个元素的列表：[1, 3, 3, 6, 7, 8, 9]，那么中位数就是这个列表中的6，因为它把列表分割成了两个等长的部分。
 * <p>
 * 如果我们有一个包含8个元素的列表：[1, 2, 3, 4, 5, 6, 8, 9]，那么中位数就是4和5的平均值，也就是4.5，因为这两个数正好将列表分割成两个等长的部分。
 * <p>
 * 在数据分析中，中位数经常被用来衡量数据的集中趋势，特别是在数据分布非常偏斜的情况下，中位数通常比平均数更能反映数据的真实情况。
 */
public class solution {
    /**
     * 不满足题目的复杂度的要求
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 数组排序
        int[] result = new int[nums1.length + nums2.length];
        int nums1Index = 0;
        int nums2Index = 0;
        int currentIndex = 0;

        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                result[currentIndex] = nums1[nums1Index];
                nums1Index +=1;
            } else {
                result[currentIndex] = nums2[nums2Index];
                nums2Index +=1;
            }
            currentIndex += 1;
        }
        // 找出没结束的那个，剩下的结果追加进去
        for (; nums1Index < nums1.length; nums1Index++) {
            result[currentIndex] = nums1[nums1Index];
            currentIndex +=1;
        }
        for (; nums2Index < nums2.length; nums2Index++) {
            result[currentIndex] = nums2[nums2Index];
            currentIndex +=1;
        }
        System.out.println(Arrays.toString(result));
        if (currentIndex % 2 == 0) {
            return (result[currentIndex / 2 -1] + result[currentIndex / 2 ]) / 2.0;

        }


        return result[currentIndex / 2];


    }


    /**
     * 采用二分查找法解决
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysBinary(int[] nums1, int[] nums2) {
        return  1.0;
    }






        public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
