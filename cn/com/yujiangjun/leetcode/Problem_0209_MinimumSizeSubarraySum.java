package cn.com.yujiangjun.leetcode;

import java.util.Arrays;
import java.util.Map;

public class Problem_0209_MinimumSizeSubarraySum {


    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            //sum[j]-sum[i]>=target， 距离就是j-i,遍历所有，取最小
            int t = target + sums[i];
            int index = Arrays.binarySearch(sums, t);
            index = Math.abs(index);
            if (index < sums.length) {
                ans = Math.min(ans, index - i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int t = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(t, nums));
        System.out.println("==================");
        int t2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println(minSubArrayLen(t2, nums2));
        System.out.println("==================");
        int t3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(t3, nums3));
        System.out.println("==================");

    }
}
