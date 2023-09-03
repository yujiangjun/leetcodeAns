package cn.com.yujiangjun.leetcode;

public class Q256 {

    public static int process(int[][] cost, int i, int color) {
        if (i == cost.length) {
            return 0;
        }
        int curCost = cost[i][color];
        int p1 = 0;
        int p2 = 0;
        if (color == 0) {
            p1 = process(cost, i + 1, 1);
            p2 = process(cost, i + 1, 2);
        } else if (color == 1) {
            p1 = process(cost, i + 1, 0);
            p2 = process(cost, i + 1, 2);
        } else {
            p1 = process(cost, i + 1, 0);
            p2 = process(cost, i + 1, 1);
        }
        return curCost + Math.min(p1, p2);
    }

    public static int minCost(int[][] cost) {
        int p1 = process(cost, 0, 0);
        int p2 = process(cost, 0, 1);
        int p3 = process(cost, 0, 2);
        return Math.min(p1, Math.min(p2, p3));
    }

    public static int minCost2(int[][] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < 3; i++) {
            dp[n][i] = 0;
        }
        int p1, p2, cur;
        for (int i = n - 1; i >= 0; i--) {
            // color 0
            p1 = dp[i + 1][1];
            p2 = dp[i + 1][2];
            cur = cost[i][0];
            dp[i][0] = cur + Math.min(p1, p2);
            p1 = dp[i + 1][0];
            p2 = dp[i + 1][2];
            cur = cost[i][1];
            dp[i][1] = cur + Math.min(p1, p2);
            p1 = dp[i + 1][0];
            p2 = dp[i + 1][1];
            cur = cost[i][2];
            dp[i][2] = cur + Math.min(p1, p2);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static int minCost3(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = 0;
        }
        int p1, p2, cur;
        int pre0, pre1, pre2;
        for (int i = n - 1; i >= 0; i--) {
            pre0 = dp[0];
            pre1 = dp[1];
            pre2 = dp[2];
            // color 0
            p1 = pre1;
            p2 = pre2;
            cur = costs[i][0];
            dp[0] = cur + Math.min(p1, p2);
            p1 = pre0;
            p2 = pre2;
            cur = costs[i][1];
            dp[1] = cur + Math.min(p1, p2);
            p1 = pre0;
            p2 = pre1;
            cur = costs[i][2];
            dp[2] = cur + Math.min(p1, p2);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        int[][] cost = {
                {7, 6, 2}
        };
        System.out.println(minCost(cost));
        System.out.println(minCost2(cost));
        System.out.println(minCost3(cost));
        System.out.println("=================");
        int[][] cost1 = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println(minCost(cost1));
        System.out.println(minCost2(cost1));
        System.out.println(minCost3(cost1));
        System.out.println("=================");
    }
}
