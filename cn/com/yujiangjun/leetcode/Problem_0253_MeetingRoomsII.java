package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0253_MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (!queue.isEmpty()&&intervals[i][0]>=queue.peek()){
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] i = {
                {0, 30}, {5, 10}, {15, 20}
        };
        System.out.println(minMeetingRooms(i));
        System.out.println("=========");
        int[][] i2 = {
                {7, 10}, {2, 4}
        };
        System.out.println(minMeetingRooms(i2));
        System.out.println("=========");
    }
}
