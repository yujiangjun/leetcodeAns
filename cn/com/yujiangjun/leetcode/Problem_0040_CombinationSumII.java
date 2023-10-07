package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0040_CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<int[]> count = new ArrayList<>();
        for (int num : candidates) {
            if (count.isEmpty() || num != count.get(count.size() - 1)[0]) {
                count.add(new int[]{num, 1});
            } else {
                count.get(count.size() - 1)[1]++;
            }
        }
        process(count, 0, target, path, ans);
        return ans;
    }

    public static void process(List<int[]> count, int index, int rest, List<Integer> path, List<List<Integer>> ans) {

        if (rest == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (rest < 0 || index == count.size()) {
            return;
        }
        //使用index位置的数
        int num = count.get(index)[0];
        if (rest - num >= 0) {
            int most = Math.min(rest / num, count.get(index)[1]);
            for (int i = 1; i <= most; i++) {
                path.add(num);
                process(count, index + 1, rest - i * num, path, ans);

            }
            for (int i = 1; i <= most; i++) {
                path.remove(path.size() - 1);
            }
        }
        // 不适用index位置的数
        process(count, index + 1, rest, path, ans);
    }

    public static List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        process2(candidates, 0, target, path, ans);
        return ans;
    }

    public static void process2(int[] candidates, int index, int rest, List<Integer> path, List<List<Integer>> ans) {

        if (rest == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (rest < 0 || index == candidates.length) {
            return;
        }
        //使用index位置的数
        int num = candidates[index];
        if (rest >= num) {
            path.add(num);
            process2(candidates, index + 1, rest - num, path, ans);
            path.remove(path.size() - 1);
        }
        while (index < candidates.length && candidates[index] == num) {
            index++;
        }
        if (index<candidates.length&&candidates[index]>rest){
            return;
        }
        // 不适用index位置的数
        process2(candidates, index, rest, path, ans);
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int t = 8;
        List<List<Integer>> res = combinationSum22(candidates, t);
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");
        int[] candidates2 = {2, 5, 2, 1, 2};
        int t2 = 5;
        List<List<Integer>> res2 = combinationSum22(candidates2, t2);
        for (List<Integer> item : res2) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");
    }
}
