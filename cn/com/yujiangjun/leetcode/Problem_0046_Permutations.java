package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0046_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, path, ans);
        return ans;
    }

    public static void process(int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (!path.contains(num)) {
                path.add(num);
                process(nums, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> ans = permute(nums1);
        for (List<Integer> item : ans) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");
        int[] nums2 = {0, 1};
        List<List<Integer>> ans2 = permute(nums2);
        for (List<Integer> item : ans2) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");
        int[] nums3 = {1};
        List<List<Integer>> ans3 = permute(nums3);
        for (List<Integer> item : ans3) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=================");

    }
}
