package cn.com.yujiangjun.leetcode;

public class Q518 {


    public static int process(int[] coins, int index, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (rest < 0) {
            return 0;
        }
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int p1 = process(coins, index + 1, rest);
        int p2 = process(coins, index, rest - coins[index]);
        return p1 + p2;
    }

    public static int change(int amount, int[] coins) {
        return process(coins, 0, amount);
    }

    public static int change1(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        dp[n][0] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int rest = 0; rest <= amount; rest++) {
                int p1 = dp[i + 1][rest];
                int p2 = 0;
                if (rest - coins[i] >= 0) {
                    p2 = dp[i][rest - coins[i]];
                }
                dp[i][rest] = p1 + p2;
            }
        }
        return dp[0][amount];
    }

    public static int change2(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int rest = 1; rest <= amount; rest++) {
                int p1 = dp[rest];
                int p2 = 0;
                if (rest - coins[i] >= 0) {
                    p2 = dp[rest - coins[i]];
                }
                dp[rest] = p1 + p2;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));
        System.out.println(change1(amount, coins));
        System.out.println(change2(amount, coins));
        System.out.println("============");
        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(change(amount1, coins1));
        System.out.println(change1(amount1, coins1));
        System.out.println(change2(amount1, coins1));
        System.out.println("============");
        int[] coins2 = {10};
        int amount2 = 10;
        System.out.println(change(amount2, coins2));
        System.out.println(change1(amount2, coins2));
        System.out.println(change2(amount2, coins2));
        System.out.println("============");

    }
}
