package cn.com.yujiangjun.leetcode;

public class Q718 {


    public static int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static int findLength2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[] dp = new int[m + 1];
        int[] pre = new int[m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(dp, 0, pre, 0, m + 1);
            for (int j = m - 1; j >= 0; j--) {
                dp[j] = nums1[i] == nums2[j] ? pre[j + 1] + 1 : 0;
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }


    public static int process(int[] nums1, int[] nums2, int i, int j) {
        int ans = 0;
        if (i < 0) {
            return 0;
        }
        if (j < 0) {
            return 0;
        }
        if (nums1[i] == nums2[j]) {
            ans = process(nums1, nums2, i - 1, j - 1) + 1;
        }
        return ans;
    }

    public static int findLength3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int res = process(nums1, nums2, i, j);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }

    public static int findLength4(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        dp[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        int ans = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = nums1[i] == nums2[0] ? 1 : 0;
            ans=Math.max(ans,dp[i][0]);
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = nums1[0] == nums2[i] ? 1 : 0;
            ans=Math.max(ans,dp[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i - 1][j - 1] + 1 : 0;
                ans=Math.max(ans,dp[i][j]);
            }
        }
//        return dp[n - 1][m - 1];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(findLength3(nums1, nums2));
        System.out.println(findLength4(nums1, nums2));
        System.out.println("=======================");

        int[] nums11 = {0, 0, 0, 0, 0};
        int[] nums22 = {0, 0, 0, 0, 0};
        System.out.println(findLength3(nums11, nums22));
        System.out.println(findLength4(nums11, nums22));
        System.out.println("=======================");
    }
}
