package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q131 {
    private static List<List<String>> result = new ArrayList<>();

    private static List<String> ans = new ArrayList<>();

    private static boolean[][] isPalindrome;


    public static List<List<String>> partition(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        isPalindrome = new boolean[n][n];
        // isPalindrome[i][j] = str[i]==str[j]并且is[i+1][j-1]是回文
        for (int i = 0; i < n; i++) {
            Arrays.fill(isPalindrome[i], true);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; ++j) {
                isPalindrome[i][j] = str[i] == str[j] && isPalindrome[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return result;
    }

    public static void dfs(String s, int i) {
        if (i == s.length()) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
        for (List<String> strings : result) {
            System.out.println(Arrays.toString(strings.toArray()));
        }
    }
}
