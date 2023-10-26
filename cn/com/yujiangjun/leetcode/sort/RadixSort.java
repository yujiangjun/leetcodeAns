package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.util.ArrayUtil;

import java.util.Arrays;

/**
 * 计数排序
 */
public class RadixSort {

    public static void radixSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        radixSort(nums, 0, nums.length - 1, getBits(nums));
    }


    public static void radixSort(int[] arr, int l, int r, int digit) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int j = 0;
        for (int d = 1; d <= digit; d++) {
            int[] bucket = new int[10];
            for (int k = l; k <= r; k++) {
                j = getDigit(arr[k], d);
                bucket[j]++;
            }
            for (i = 1; i < bucket.length; i++) {
                bucket[i] = bucket[i] + bucket[i - 1];
            }

            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                help[bucket[j] - 1] = arr[i];
                bucket[j]--;
            }
            for (int k = 0; k < help.length; k++) {
                arr[l + k] = help[k];
            }
        }
    }

    public static int getBits(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int ctn = 0;
        while (max != 0) {
            ctn++;
            max /= 10;
        }
        return ctn;
    }

    public static int getDigit(int x, int d) {
        return (int) ((x / Math.pow(10, d - 1)) % 10);
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        System.out.println(Arrays.toString(nums));
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
