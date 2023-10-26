package cn.com.yujiangjun.niuke;

public class BM17 {

    public static int search(int[] nums, int target) {
        // write code here
        if (nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
        int t = 13;
        System.out.println(search(nums, t));
        int[] nums2 = {-1,0,3,4,6,10,13,14};
        int t2 = 2;
        System.out.println(search(nums2, t2));
    }
}
