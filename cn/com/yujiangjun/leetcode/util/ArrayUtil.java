package cn.com.yujiangjun.leetcode.util;

import java.util.Random;

public class ArrayUtil {

    public static void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    public static int[] create(int len, int maxValue) {
        int[] ans = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            ans[i] = random.nextInt(maxValue);
        }
        return ans;
    }
}
