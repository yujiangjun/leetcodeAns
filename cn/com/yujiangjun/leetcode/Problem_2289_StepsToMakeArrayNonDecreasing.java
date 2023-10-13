package cn.com.yujiangjun.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_2289_StepsToMakeArrayNonDecreasing {

    public static int totalSteps(int[] nums) {
        int ctn = 0;
        int index = 0;
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        boolean isOp = false;
        while (index % n < n) {
            if (index % n == 0) {
                stack.clear();
                isOp = false;
            }

            if (nums[index % n] != 0) {
                while (!stack.isEmpty() && stack.peek() <= nums[index % n]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    isOp = true;
                    nums[index % n] = 0;
                }

                stack.push(nums[index % n]);
            }

            if (index % n == n - 1 && isOp) {
                ctn++;
            }
            if (index % n == n - 1 && !isOp) {
                break;
            }
            index++;
        }
        return ctn;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        System.out.println(totalSteps(nums));
        System.out.println("================");
        int[] nums2 = {4, 5, 7, 7, 13};
        System.out.println(totalSteps(nums2));
        System.out.println("================");

    }
}
