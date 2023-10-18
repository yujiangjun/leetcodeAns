package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0347_TopKFrequentElements {

    public static class Info {
        public int num;
        public int count;

        public Info(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Info> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.get(num).count++;
            } else {
                Info info = new Info(num, 1);
                map.put(num, info);
            }
        }

        PriorityQueue<Info> queue = new PriorityQueue<>(new InfoCompare());
        for (Map.Entry<Integer, Info> entry : map.entrySet()) {
            if (queue.size() < k || (queue.size() == k && entry.getValue().count > queue.peek().count)) {
                queue.add(entry.getValue());
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll().num;
        }
        return ans;
    }

    public static class InfoCompare implements Comparator<Info> {

        @Override
        public int compare(Info o1, Info o2) {
            return o1.count - o2.count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        System.out.println("============");

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2)));

    }
}
