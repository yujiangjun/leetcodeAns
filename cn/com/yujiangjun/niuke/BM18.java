package cn.com.yujiangjun.niuke;

import java.util.Arrays;

public class BM18 {

    public static boolean Find(int target, int[][] array) {
        // write code here

        for (int[] nums : array) {
            if (nums.length == 0) {
                continue;
            }
            int start=nums[0];
            int end=nums[nums.length - 1];
            if (target<start){
                return false;
            }else if (target==start||target==end){
                return true;
            }else if (start < target && end > target) {
                int ans = Arrays.binarySearch(nums, target);
                if (ans > -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}
        };
        int t = 5;
        System.out.println(Find(t, arr));
    }
}
