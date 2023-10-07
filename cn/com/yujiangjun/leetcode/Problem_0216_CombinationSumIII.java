package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0216_CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        process(1, k, n, path, ans);
        return ans;
    }

    public static void process(int i, int count, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (count == 0 && sum == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (count < 0 || sum < 0||i>9) {
            return;
        }
        if (sum >= i) {
            //选择
            path.add(i);
            process(i + 1, count - 1, sum - i, path, ans);
            path.remove(path.size() - 1);
        }
        if (sum >= (i + 1)) {
            process(i + 1, count, sum, path, ans);
        }
    }

    public static void main(String[] args) {
        int k1=3,n1=7;
        List<List<Integer>> res = combinationSum3(k1, n1);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("===================");
        int k2=3,n2=9;
        List<List<Integer>> res2 = combinationSum3(k2, n2);
        for (List<Integer> item : res2) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("===================");
        int k3=4,n3=1;
        List<List<Integer>> res3 = combinationSum3(k3, n3);
        for (List<Integer> item : res3) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }
}
