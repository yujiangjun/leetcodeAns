package cn.com.yujiangjun.leetcode;

public class Problem_0031_NextPermutation {

    public static void nextPermutation(int[] nums) {
        int firstLess = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstLess = i;
                break;
            }
        }
        if (firstLess < 0) {
            reserve(nums, 0, nums.length - 1);
        } else {
            // firstLess最靠右比它大的数
            int right = -1;
            for (int i = nums.length - 1; i > firstLess; i--) {
                if (nums[i] > nums[firstLess]) {
                    right = i;
                    break;
                }
            }
            swap(nums, firstLess, right);
            reserve(nums, right + 1, nums.length - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void reserve(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
