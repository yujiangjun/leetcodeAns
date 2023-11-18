package cn.com.yujiangjun.niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class BM45 {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here

        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || size == 0 || num.length < size) {
            return ans;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] < num[index]) {
                queue.pollLast();
            }
            queue.addLast(index++);
        }
        for (; index < num.length; index++) {
            ans.add(num[queue.peekFirst()]);
            while (!queue.isEmpty() && num[queue.peekLast()] < num[index]) {
                queue.pollLast();
            }
            queue.addLast(index);
            int left = index - size;
            if (left == queue.peekFirst()) {
                queue.pollFirst();
            }
        }
        ans.add(num[queue.peekFirst()]);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(Arrays.toString(maxInWindows(num, size).toArray()));

        int[] num2 = {9, 10, 9, -7, -3, 8, 2, -6};
        int size2 = 5;
        System.out.println(Arrays.toString(maxInWindows(num2, size2).toArray()));
        int[] num3 = {1, 2, 3, 4};
        int size3 = 5;
        System.out.println(Arrays.toString(maxInWindows(num3, size3).toArray()));
    }
}
