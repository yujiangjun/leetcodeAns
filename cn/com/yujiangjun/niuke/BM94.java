package cn.com.yujiangjun.niuke;

import java.util.Deque;
import java.util.LinkedList;

public class BM94 {

    public long maxWater(int[] arr) {
        // write code here
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int width = i - left - 1;
                int height = Math.min(arr[i], arr[left]) - arr[pop];
                ans += (height * width);
            }
            stack.push(i);
        }
        return ans;
    }
}
