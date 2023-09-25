package cn.com.yujiangjun.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2462 {

    public static long totalCost(int[] costs, int k, int candidates) {
        if (costs == null || costs.length == 0 || k < 1 || candidates < 1) {
            return 0;
        }

        PriorityQueue<F> fs = new PriorityQueue<>(new FComparator());
        long sum = 0;
        if (costs.length <= candidates) {
            for (int i = 0; i < costs.length; i++) {
                fs.add(new F(costs[i], i));
            }
            for (int i = 0; i < k; i++) {
                sum += fs.poll().cost;
            }
            return sum;
        }

        int n = costs.length;
        int l = 0;
        int r = n - 1;
        PriorityQueue<F> left = new PriorityQueue<>(new FComparator());
        PriorityQueue<F> right = new PriorityQueue<>(new FComparator());
        for (int i = 0; i < candidates; i++) {
            if (r > l) {
                left.add(new F(costs[l], l++));
                right.add(new F(costs[r], r--));
            }
        }
        for (int i = 0; i < k; i++) {
            if (left.isEmpty()) {
                sum += right.poll().cost;
            } else if (right.isEmpty()) {
                sum += left.poll().cost;
            } else {
                F leftF = left.peek();
                F rightF = right.peek();
                if (rightF.cost < leftF.cost) {
                    sum += right.poll().cost;
                    if (r >= l) {
                        right.add(new F(costs[r], r--));
                    }
                } else {
                    sum += left.poll().cost;
                    if (r >= l) {
                        left.add(new F(costs[l], l++));
                    }
                }
            }
        }
        return sum;
    }

    private static class F {
        private int cost;
        private int index;

        public F(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }

    private static class FComparator implements Comparator<F> {

        @Override
        public int compare(F o1, F o2) {
            return o1.cost != o2.cost ? o1.cost - o2.cost : o1.index - o2.index;
        }
    }

    public static void main(String[] args) {
        int[] costs1 = {1, 2, 4, 1};
        int k1 = 3;
        int candidates1 = 4;
        System.out.println(totalCost(costs1, k1, candidates1));
        System.out.println("======================");
        int[] costs2 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k2 = 3;
        int candidates2 = 4;
        System.out.println(totalCost(costs2, k2, candidates2));
        System.out.println("======================");
    }
}
