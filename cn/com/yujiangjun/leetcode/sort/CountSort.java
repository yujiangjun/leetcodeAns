package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.leetcode.util.ArrayUtil;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSort {

    public static void countSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] bucket = new int[max + 1];

        for (int num : nums) {
            bucket[num]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                nums[index++] = i;
                bucket[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        System.out.println(Arrays.toString(nums));
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
