package cn.com.yujiangjun.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Problem_2289_StepsToMakeArrayNonDecreasing {

    public static int totalSteps(int[] nums) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans = Math.max(ans, i - stack.peek());
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        System.out.println(totalSteps(nums));
        System.out.println("================");
        int[] nums2 = {4, 5, 7, 7, 13};
        System.out.println(totalSteps(nums2));
        System.out.println("================");
        int[] nums3 = {10, 1, 2, 3, 4, 5, 6, 1, 2, 3};
        System.out.println(totalSteps(nums3));
        System.out.println("================");
    }
}
