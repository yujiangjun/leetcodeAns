package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q241 {

    public static List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        return dfs(expression, map);
    }

    public static int parseInt(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return -1;
            }
        }
        return Integer.parseInt(str);
    }


    public static List<Integer> dfs(String s, Map<String, List<Integer>> map) {
        List<Integer> ans = new ArrayList<>();
        if (parseInt(s) >= 0) {
            ans.add(parseInt(s));
            map.put(s, ans);
            return ans;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                List<Integer> left = dfs(s.substring(0, i), map);
                List<Integer> right = dfs(s.substring(i + 1), map);
                for (int x = 0; x < left.size(); x++) {
                    for (int y = 0; y < right.size(); y++) {
                        if (s.charAt(i) == '+') {
                            ans.add(left.get(x) + right.get(y));
                        } else if (s.charAt(i) == '-') {
                            ans.add(left.get(x) - right.get(y));
                        } else {
                            ans.add(left.get(x) * right.get(y));
                        }
                    }
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}
