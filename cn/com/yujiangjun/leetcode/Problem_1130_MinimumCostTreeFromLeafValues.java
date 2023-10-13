package cn.com.yujiangjun.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_1130_MinimumCostTreeFromLeafValues {


    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() < num) {
                Integer y = stack.pop();
                if (stack.isEmpty() || stack.peek() > num) {
                    res += num * y;
                } else {
                    res += stack.peek() * y;
                }
            }
            stack.push(num);
        }

        while (stack.size() > 1) {
            Integer y = stack.pop();
            res += y * stack.peek();
        }
        return res;
    }
}
