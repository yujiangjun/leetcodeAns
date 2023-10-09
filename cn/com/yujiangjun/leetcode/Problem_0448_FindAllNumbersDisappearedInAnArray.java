package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0448_FindAllNumbersDisappearedInAnArray {


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n= nums.length;
        for (int num : nums) {
            int x=(num-1)%n;
            nums[x]+=n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=n){
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//        System.out.println(Arrays.toString(findDisappearedNumbers(nums).toArray()));
//        System.out.println("==============");
//
//        int[] nums2 = {1, 1};
//        System.out.println(Arrays.toString(findDisappearedNumbers(nums2).toArray()));
//        System.out.println("==============");
//        int[] nums3 = {4, 7, 7, 7, 8, 7, 3, 1};
//        System.out.println(Arrays.toString(findDisappearedNumbers(nums3).toArray()));
//        System.out.println("==============");
        int[] nums4 = {10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        System.out.println(Arrays.toString(findDisappearedNumbers(nums4).toArray()));
        System.out.println("==============");
    }
}
