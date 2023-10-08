package cn.com.yujiangjun.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem_0239_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        ans[0]=nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty()&&deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            ans[i-k+1]=nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(n1, k1)));
        System.out.println(Arrays.toString(maxSlidingWindow2(n1, k1)));
    }
}
