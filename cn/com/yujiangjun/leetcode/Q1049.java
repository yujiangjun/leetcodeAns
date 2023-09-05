package cn.com.yujiangjun.leetcode;

public class Q1049 {

    public static int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length;
        int amount = sum / 2;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < n; i++) {
            for (int rest = amount; rest >= stones[i]; rest--) {
                dp[rest] = Math.max(dp[rest], dp[rest - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[amount];
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
        System.out.println("---------------");
    }
}
