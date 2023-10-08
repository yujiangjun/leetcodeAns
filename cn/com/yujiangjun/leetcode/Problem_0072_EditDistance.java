package cn.com.yujiangjun.leetcode;

public class Problem_0072_EditDistance {


    public static int minDistance(String word1, String word2) {
        return process(word1.toCharArray(), word2.toCharArray(), 0, 0);
    }

    public static int process(char[] word1, char[] word2, int i, int j) {
        if (i == word1.length && j == word2.length) {
            return 0;
        } else if (j == word2.length) {
            // j到达最后，word1只等通过删除到达word2
            return process(word1, word2, i + 1, j) + 1;
        } else if (i == word1.length) {
            //i 到达最后，word1只能通过插入叨叨word2
            return process(word1, word2, i, j + 1) + 1;
        }
        if (word1[i] == word2[j]) {
            return process(word1, word2, i + 1, j + 1);
        }
        // 替换
        int p1 = process(word1, word2, i + 1, j + 1);
        // 删除
        int p2 = process(word1, word2, i + 1, j);
        //新增
        int p3 = process(word1, word2, i, j + 1);
        return Math.min(p1, Math.min(p2, p3)) + 1;
    }

    public static int minDistance2(String word1, String word2) {
        if ((word1 == null || word1.isEmpty()) && (word2 == null || word2.isEmpty())) {
            return 0;
        } else if (word1 == null || word1.isEmpty()) {
            return word2.length();
        } else if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            dp[n][i] = dp[n][i + 1] + 1;
        }
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int p1 = dp[i + 1][j + 1];
                    int p2 = dp[i + 1][j];
                    int p3 = dp[i][j + 1];
                    dp[i][j] = Math.min(p1, Math.min(p2, p3)) + 1;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
        System.out.println(minDistance2(word1, word2));
        System.out.println("================");
        String word12 = "intention";
        String word22 = "execution";
        System.out.println(minDistance(word12, word22));
        System.out.println(minDistance2(word12, word22));
        System.out.println("================");

    }
}
