package cn.com.yujiangjun.leetcode.sort;

import cn.com.yujiangjun.util.ArrayUtil;

import java.util.Arrays;
/**
 * 选择排序
 */
public class SelectSort {


    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min==i){
                continue;
            }
            ArrayUtil.swap(nums, min, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.create(10, 50);
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
