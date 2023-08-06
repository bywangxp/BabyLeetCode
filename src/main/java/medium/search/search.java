package medium.search;

/**
 *
 */
public class search {

    public static int search(int[] arr, int target) {
        int result = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] == target) {
                result = left;
                break;
            }
            if (arr[right] == target) {
                result = right;
                break;

            }
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                break;
            }
            // 找出有序的数组
            if (arr[left] < arr[mid]) {
                // 左边有序
                if (arr[left] < target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[right] > arr[mid]) {
                // 右边边有序

                if (arr[right] > target && target > arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                // 如果左右都判断不了是否有序，则 选一遍递增 或者递减，慢慢逼近
                // 当左边界和中间元素相等时。这种情况下，无法通过比较左边界和中间元素来确定哪一侧是有序的，因此这里直接将左边界向右移动一位。这是一种有效的处理方式，因为如果目标值等于左边界，那么就已经找到了目标值，可以直接返回；如果目标值不等于左边界，那么左边界的元素就可以被排除掉，向右移动一位不会有任何问题。
                left++;


            }


        }

        if (result == -1) {
            return result;
        }


        // 继续找到最小的元素
        while (result > 0 && arr[result - 1] == target) {
            result--;

        }

        return result;


    }

    public static int search2(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[l] < arr[m]) {
                if (arr[l] <= target && target <= arr[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (arr[l] > arr[m]) {
                if (arr[m] <= target && target <= arr[r] && arr[l] > arr[r]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else if (arr[l] == arr[m]) {
                if (target != arr[l]) {
                    l++;
                } else {
                    return l;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {


//        System.out.println(search(new int[]{2, 1, 2, 2, 2}, 1));
        System.out.println(search2(new int[]{1}, 1));
    }


}
