package cn.com.yujiangjun.leetcode;

public class Problem_0377_CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0, target);
    }

    public static int process(int[] nums, int i, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (rest < 0 || i == nums.length) {
            return 0;
        }
        int sum = 0;
        // 选
        sum += process(nums, 0, rest - nums[i]);
        //不选
        sum += process(nums, i + 1, rest);
        return sum;
    }

    public static int combinationSum42(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= target; i++) {
            dp[n][i] = 0;
        }
        for (int rest = 1; rest <= target; rest++) {
            for (int i = n - 1; i >= 0; i--) {
                dp[i][rest] = dp[i + 1][rest];
                if (rest >= nums[i]) {
                    dp[i][rest] += dp[0][rest - nums[i]];
                }
            }
        }
        return dp[0][target];
    }

    public static int combinationSum43(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                dp[i] += (i >= num ? dp[i - num] : 0);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int t = 4;
        System.out.println(combinationSum4(nums, t));
        System.out.println(combinationSum42(nums, t));
        System.out.println(combinationSum43(nums, t));
        System.out.println("=================");
        int[] nums2 = {9};
        int t2 = 3;
        System.out.println(combinationSum4(nums2, t2));
        System.out.println(combinationSum42(nums2, t2));
        System.out.println(combinationSum43(nums2, t2));
    }
}
