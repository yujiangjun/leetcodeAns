package cn.com.yujiangjun.leetcode;

import java.util.PriorityQueue;

public class Problem_2530_MaximalScoreAfterApplyingKOperations {

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        long ans = 0;
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            ans += poll;
            queue.add(ceil(poll, 3));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        System.out.println(maxKelements(nums, k));
        System.out.println("===================");
        int[] nums2 = {1, 10, 3, 3, 3};
        int k2 = 3;
        System.out.println(maxKelements(nums2, k2));
        System.out.println("===================");

    }

    public static int ceil(int a, int b) {
        return (a - 1) / b + 1;
    }


}
