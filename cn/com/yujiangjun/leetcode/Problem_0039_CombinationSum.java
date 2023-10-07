package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0039_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        process(candidates, 0, target, path, ans);
        return ans;
    }

    public static void process(int[] candidates, int index, int rest, List<Integer> path, List<List<Integer>> ans) {
        if (index == candidates.length) {
            if (rest == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (rest < 0) {
            return;
        }
        //使用index位置的数
        path.add(candidates[index]);
        if (rest-candidates[index]>=0){
            process(candidates, index, rest - candidates[index], path, ans);
        }
        path.remove(path.size() - 1);
        // 不适用index位置的数
        process(candidates, index + 1, rest, path, ans);
    }



    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int t = 7;
        List<List<Integer>> res = combinationSum(candidates, t);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");
        int[] candidates2 = {2, 3, 5};
        int t2 = 8;
        List<List<Integer>> res2 = combinationSum(candidates2, t2);
        for (List<Integer> item : res2) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");

        int[] candidates3 = {2};
        int t3 = 1;
        List<List<Integer>> res3 = combinationSum(candidates3, t3);
        for (List<Integer> item : res3) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }
}
