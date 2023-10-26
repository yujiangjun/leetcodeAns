package cn.com.yujiangjun.niuke;

public class BM21 {

    public static int minNumberInRotateArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(nums));
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(nums3));
        int[] nums2 = {3, 100, 200, 3};
        System.out.println(minNumberInRotateArray(nums2));
        int[] nums4 = {5, 1, 2, 3, 4};
        System.out.println(minNumberInRotateArray(nums4));

    }
}
