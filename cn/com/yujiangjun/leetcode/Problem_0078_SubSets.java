package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0078_SubSets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        process(nums, 0, ans);
        ans.add(new ArrayList<>());
        return ans;
    }

    public static void process(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            return;
        }
        List<List<Integer>> newAns = new ArrayList<>();
        for (List<Integer> item : ans) {
            List<Integer> newItem = new ArrayList<>(item);
            newItem.add(nums[i]);
            newAns.add(newItem);
        }
        ans.addAll(newAns);
        List<Integer> newItem = new ArrayList<>();
        newItem.add(nums[i]);
        ans.add(newItem);
        process(nums, i + 1, ans);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);
        for (List<Integer> item : ans) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }
}
