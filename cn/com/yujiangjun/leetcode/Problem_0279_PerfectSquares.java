package cn.com.yujiangjun.leetcode;

public class Problem_0279_PerfectSquares {

    public static int numSquares(int n) {
        return process(1, n, n);
    }

    public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j * j < i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static int process(int i, int n, int rest) {
        if (rest == 0) {
            return 0;
        }
        if (i > n || rest < 0) {
            return Integer.MAX_VALUE;
        }
        //使用i这个数
        int p1 = process(i, n, rest - i * i);
        p1 = (p1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : p1 + 1);
        int p2 = process(i + 1, n, rest);
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
        System.out.println(numSquares2(n));
        System.out.println("=================");
        int n2 = 13;
        System.out.println(numSquares(n2));
        System.out.println(numSquares2(n2));
        System.out.println("=================");

        int n3 = 1;
        System.out.println(numSquares(n3));
        System.out.println(numSquares2(n3));
        System.out.println("=================");
    }
}
