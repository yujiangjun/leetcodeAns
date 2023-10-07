package cn.com.yujiangjun.leetcode;

public class Problem_0042_TrapRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int l = 1;
        int r = n - 2;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int water = 0;
        while (l <= r) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l++]);
            } else {
                water += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r--]);
            }
        }
        return water;
    }


}
