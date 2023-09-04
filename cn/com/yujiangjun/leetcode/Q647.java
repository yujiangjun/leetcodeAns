package cn.com.yujiangjun.leetcode;

public class Q647 {

    public static int countSubStrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = str[i] == str[i + 1];
        }
        dp[n - 1][n - 1] = true;
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = str[i] == str[j] && dp[i + 1][j - 1];
            }
        }

        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="abc";
        System.out.println(countSubStrings(s));
        System.out.println("====================");
        String s1="aaa";
        System.out.println(countSubStrings(s1));
        System.out.println("====================");

    }
}
