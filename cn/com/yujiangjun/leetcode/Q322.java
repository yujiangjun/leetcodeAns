package cn.com.yujiangjun.leetcode;

import java.util.Arrays;

public class Q322 {


    public static int process(int[] coins, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }

        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return Integer.MAX_VALUE;
        }
        // 不适用index的硬币
        int p1Next = process(coins, index + 1, rest);

        int p2Next = process(coins, index, rest - coins[index]);

        int p2 = p2Next == Integer.MAX_VALUE ? Integer.MAX_VALUE : p2Next + 1;
        return Math.min(p1Next, p2);
    }


    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int res = process(coins, 0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int rest = 0; rest <= amount; rest++) {
                int p1Next = dp[i + 1][rest];
                int p2Next = Integer.MAX_VALUE;
                if (rest - coins[i] >= 0) {
                    p2Next = dp[i][rest - coins[i]];
                }
                int p2 = p2Next == Integer.MAX_VALUE ? Integer.MAX_VALUE : p2Next + 1;
                dp[i][rest] = Math.min(p2, p1Next);
            }
        }
        int res = dp[0][amount];
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int rest = 0; rest <= amount; rest++) {
                int p1Next = dp[rest];
                int p2Next = Integer.MAX_VALUE;
                if (rest - coins[i] >= 0) {
                    p2Next = dp[rest - coins[i]];
                }
                int p2 = p2Next == Integer.MAX_VALUE ? Integer.MAX_VALUE : p2Next + 1;
                dp[rest] = Math.min(p2, p1Next);
            }
        }
        int res = dp[amount];
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange1(coins, amount));
        System.out.println(coinChange2(coins, amount));
        System.out.println("---------------");

        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChange1(coins1, amount1));
        System.out.println(coinChange2(coins1, amount1));
        System.out.println("---------------");

        int[] coins2 = {1};
        int amount3 = 0;
        System.out.println(coinChange(coins2, amount3));
        System.out.println(coinChange1(coins2, amount3));
        System.out.println(coinChange2(coins2, amount3));
        System.out.println("---------------");
    }
}
