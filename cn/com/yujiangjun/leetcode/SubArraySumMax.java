package cn.com.yujiangjun.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 子数组和的最大值
 */
public class SubArraySumMax {


    /**
     * 计算以index为结尾的子数组的和的最大值
     *
     * @param index
     * @return
     */
    public static int process(int index, int[] arr) {
        if (index == 0) {
            return arr[0];
        }
        // 0~index-1 和index组成0~index新的子数组
        int p1 = process(index - 1, arr) + arr[index];
        // 以index为一个子数组
        int p2 = arr[index];
        return Math.max(p1, p2);
    }

    public static int ways(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int res = process(i, nums);
            ans = Math.max(ans, res);
        }
        return ans;
    }

    public static int ways2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
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
        int[] data = {1, 2, 3, 4};
        System.out.println(ways(data) == ways2(data));
        int[] data1 = {2, -1, 3, 1};
        System.out.println(ways(data1) == ways2(data1));
        int test = 1000;
        int maxValue = 30;
        int size = 20;
        for (int i = 0; i < test; i++) {
            int[] data3 = createArray(size, maxValue);
            if (ways(data3) != ways2(data3)) {
                System.out.println(Arrays.toString(data3));
                System.out.println(ways(data3));
                System.out.println(ways2(data3));
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("成功");
    }
}
