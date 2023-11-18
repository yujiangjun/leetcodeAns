package cn.com.yujiangjun.leetcode.sort;

import java.util.Random;

public class Interview1714_SmallestKLCCI {

    public int[] smallestK(int[] arr, int k) {
        randomizedSelect(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }


    public static void randomizedSelect(int[] arr, int l, int r, int k) {
        if (r <= l) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (num == k) {
            return;
        }
        if (k > num) {
            randomizedSelect(arr, pos + 1, r, k - num);
        } else {
            randomizedSelect(arr, l, pos - 1, k);
        }
    }

    public static int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int p = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= p) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
