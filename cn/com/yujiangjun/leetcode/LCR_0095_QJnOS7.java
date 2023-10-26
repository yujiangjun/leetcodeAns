package cn.com.yujiangjun.leetcode;

import java.util.Map;

public class LCR_0095_QJnOS7 {

    public static int longestCommonSubsequence(String text1, String text2) {
        String str1 = text1.length() > text2.length() ? text1 : text2;
        String str2 = text1.length() <= text2.length() ? text1 : text2;
        return process(str1.toCharArray(), str2.toCharArray(), 0, 0);
    }


    public static int process(char[] s1, char[] s2, int i, int j) {
        if (j == s2.length) {
            return 0;
        }
        if (i == s1.length) {
            return 0;
        }

        if (s1[i] == s2[j]) {
            return process(s1, s2, i + 1, j + 1) + 1;
        }

        int p1 = process(s1, s2, i + 1, j + 1);
        int p2 = process(s1, s2, i + 1, j);
        int p3 = process(s1, s2, i, j + 1);
        return Math.max(p1, Math.max(p2, p3));
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        String str1 = text1.length() > text2.length() ? text1 : text2;
        String str2 = text1.length() <= text2.length() ? text1 : text2;

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int ans = 0;
                if (s1[i] == s2[j]) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    ans = dp[i + 1][j];
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                    ans = Math.max(ans, dp[i][j + 1]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s14 = "psnw";
        String s24 = "vozsh";
        System.out.println(longestCommonSubsequence(s14, s24));
        System.out.println(longestCommonSubsequence2(s14, s24));
        System.out.println("===================");
    }
}
