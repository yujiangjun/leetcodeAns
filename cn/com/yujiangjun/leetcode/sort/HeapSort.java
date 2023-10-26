package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.util.ArrayUtil;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {


    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            heapify(nums, i, n);
//        }
        for (int i = 0; i < n; i++) {
            heapInsert(nums, i);
        }
        ArrayUtil.swap(nums, 0, --n);
        while (n > 0) {
            heapify(nums, 0, n);
            ArrayUtil.swap(nums, 0, --n);
        }
    }

    public static void heapInsert(int[] nums, int index) {
        int father = (index - 1) / 2;
        while (nums[index] > nums[father]) {
            ArrayUtil.swap(nums, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1;
        while (left < heapSize) {
            int big = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            big = arr[big] > arr[index] ? big : index;
            if (big == index) {
                break;
            }
            ArrayUtil.swap(arr, index, big);
            index = big;
            left = (index << 1) + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
