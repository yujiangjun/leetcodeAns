package cn.com.yujiangjun.leetcode;

public class Problem_0713_SubarrayProductLessThanK {


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return 0;
        }

        int sum=1;
        int count=1;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            sum*=nums[i];
            while (j<=i&&sum>=k){
                sum/=nums[j];
                j++;
            }
            count+=(i-j+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        System.out.println(numSubarrayProductLessThanK(nums, k));
        int[] nums2 = {57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22};
        int k2 = 18;
        System.out.println(numSubarrayProductLessThanK(nums2, k2));
        System.out.println("==================");

    }
}
