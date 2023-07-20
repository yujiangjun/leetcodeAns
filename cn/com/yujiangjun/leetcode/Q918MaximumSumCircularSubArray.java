package cn.com.yujiangjun.leetcode;

import java.util.Arrays;
import java.util.Random;

public class Q918MaximumSumCircularSubArray {

    public static int maxSubarraySumCircular(int[] nums) {
        int maxS = Integer.MIN_VALUE;
        int minS = 0;
        int maxF = 0;
        int minF = 0;
        int sum = 0;
        for (int num : nums) {
            maxF = Math.max(maxF, 0) + num;
            maxS = Math.max(maxS, maxF);
            minF = Math.min(minF, 0) + num;
            minS = Math.min(minS, minF);
            sum += num;
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);
    }


    public static int ways2(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[] data = new int[nums.length * 2];
        System.arraycopy(nums, 0, data, 0, nums.length);
        System.arraycopy(nums, 0, data, nums.length, nums.length);
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int end = i + n;
            for (int j = i; j < end; j++) {
                sum += data[j];
                max = Math.max(max, sum);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static int[] createArray(int size, int maxValue) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(maxValue * 2) - maxValue;
        }
        return data;
    }

    public static void main(String[] args) {
        int test = 1000;
        int maxValue = 30;
        int size = 5;
        for (int i = 0; i < test; i++) {
            int[] data3 = createArray(size, maxValue);
            if (maxSubarraySumCircular(data3) != ways2(data3)) {
                System.out.println(Arrays.toString(data3));
                System.out.println(maxSubarraySumCircular(data3));
                System.out.println(ways2(data3));
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("成功");
    }
}
