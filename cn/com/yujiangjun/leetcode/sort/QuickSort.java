package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.util.ArrayUtil;

import java.util.Arrays;
/**
 * 快速排序
 */
public class QuickSort {


    public static void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = nums[i];

        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= key) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        sort(nums, left, i - 1);
        sort(nums, j + 1, right);
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                ArrayUtil.swap(arr, index++, ++less);
            } else {
                ArrayUtil.swap(arr, index, --more);
            }
        }
        ArrayUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void sort2(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] flag = netherlandsFlag(nums, l, r);
        sort2(nums, l, flag[0] - 1);
        sort2(nums, flag[1] + 1, r);
    }

    public static void quickSort2(int[] nums) {
        sort2(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums2.length);
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
        quickSort2(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
