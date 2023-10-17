package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.leetcode.util.ArrayUtil;

import java.util.Arrays;
/**
 * 插入排序
 */
public class InsertSort {


    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                ArrayUtil.swap(nums, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
