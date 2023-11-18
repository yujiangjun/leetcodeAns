package cn.com.yujiangjun.niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BM46 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (input == null || k == 0 || input.length < k) {
            return ans;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j : input) {
            heap.add(j);
        }

        for (int i = 0; i < k; i++) {
            ans.add(heap.poll());
        }
        return ans;
    }
}
