package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.leetcode.util.ArrayUtil;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void mergeSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }


    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int index = 0;
        while (p1 <= m && p2 <= r) {
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
    }


    public static void mergeSort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int step = 1;
        while (step < n) {
            int l = 0;
            while (l < n) {
                if (step >= n - l) {
                    break;
                }
                int m = l + step - 1;
                int r = m + Math.min(step, n - m - 1);
                merge(nums, l, m, r);
                l = r + 1;
            }
            if (step > n / 2) {
                break;
            }
            step <<= 1;
        }

    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
        mergeSort2(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
