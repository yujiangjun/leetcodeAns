package cn.com.yujiangjun.leetcode;

public class Problem_1004_MaxConsecutiveOnesiii {

    public static int longestOnes(int[] nums, int k) {

        int ans = 0;

        int l = 0;
        int count = 0;
        int r = 0;
        for (; r < nums.length; r++) {
            if (nums[r] == 1) {
                continue;
            }
            if (nums[r] == 0) {
                count++;
            }
            while (l <= r && count > k) {
                ans = Math.max(ans, r - l);
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
        }
        ans = Math.max(ans, r - l);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
        System.out.println("==============");
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.println(longestOnes(nums2, k2));
        System.out.println("==============");
        int[] nums3 = {0, 0, 0, 1};
        int k3 = 4;
        System.out.println(longestOnes(nums3, k3));
        System.out.println("==============");

    }
}
