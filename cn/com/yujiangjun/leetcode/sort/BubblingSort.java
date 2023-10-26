package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.util.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {


    public static void bubblingSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtil.swap(nums, j, j + 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        System.out.println(Arrays.toString(nums));
        bubblingSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
