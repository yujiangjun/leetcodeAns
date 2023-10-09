package cn.com.yujiangjun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_0560_SubArraySumEqualsK {


    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += process(nums, i, k);
        }
        return ans;
    }

    public static int process(int[] nums, int i, int rest) {
        if (i == 0) {
            if (rest == nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        int p1 = nums[i] == rest ? 1 : 0;
        int p2 = process(nums, i - 1, rest - nums[i]);
        return p1 + p2;
    }

    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cout = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cout += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cout;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum2(nums, k));
        System.out.println("================");
        int[] nums2 = {-1, -1, 1};
        int k2 = 0;
        System.out.println(subarraySum(nums2, k2));
        System.out.println(subarraySum2(nums2, k2));
        System.out.println("================");
    }
}
