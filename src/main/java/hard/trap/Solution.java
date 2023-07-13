package hard.trap;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode.cn/problems/trapping-rain-water/
 */


public class Solution {
    /**
     * 经过chatgpt提示：  遍历每一个节点，找出左边、右边 分别最高的节点，然后 - 当前的节点，则为蓄水的量
     * 使用双指针的方案遍历
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            int start = 0;
            int end = height.length - 1;
            int tempLeftHight = 0;
            int tempRightHight = 0;
            while (start < i) {
                if (height[start] > height[i] && tempLeftHight < height[start]) {
                    tempLeftHight = height[start];
                }
                start++;

            }
            while (end > i) {
                if (height[end] > height[i] && tempRightHight < height[end]) {
                    tempRightHight = height[end];
                }
                end--;
            }
            if (tempLeftHight >= tempRightHight && tempRightHight > height[i]) {

                result += tempRightHight - height[i];

            } else if (tempLeftHight < tempRightHight && tempLeftHight > height[i]) {

                result += tempLeftHight - height[i];


            }

        }


        return result;
    }

    /**
     * 维护了从左开始、从右开始最大的元素
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {

        if (height.length < 3) {
            return 0;
        }
        int result = 0;

        int left = 0;
        int right = height.length - 1;
        int leftHighNum = 0;
        int rightHighNum = 0;

        while (left <= right) {
            if (leftHighNum < rightHighNum) {
                if (height[left] < leftHighNum) {
                    result += leftHighNum - height[left];
                } else {
                    leftHighNum = height[left];
                }
                left++;


            } else {

                if (height[right] < rightHighNum) {
                    result += rightHighNum - height[right];
                } else {
                    rightHighNum = height[right];
                }
                right--;
            }


        }
        return result;


    }


    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap2(new int[]{4, 2, 0, 3, 2, 5}));
    }

}
