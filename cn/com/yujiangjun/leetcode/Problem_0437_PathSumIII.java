package cn.com.yujiangjun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_0437_PathSumIII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        ans += process(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }


    public static int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return process2(root, map, 0, targetSum);
    }

    public static int process2(TreeNode head, Map<Long, Integer> prefixSum, long cur, long targetSum) {
        if (head == null) {
            return 0;
        }
        int ans = 0;
        cur += head.val;
        ans = prefixSum.getOrDefault(cur - targetSum, 0);
        prefixSum.put(cur, prefixSum.getOrDefault(cur, 0) + 1);
        ans += process2(head.left, prefixSum, cur, targetSum);
        ans += process2(head.right, prefixSum, cur, targetSum);

        prefixSum.put(cur, prefixSum.getOrDefault(cur, 0) - 1);
        return ans;
    }

    public static int process(TreeNode head, int rest) {
        if (head == null) {
            return 0;
        }
        int res = 0;
        if (head.val == res) {
            res++;
        }
        res += process(head.left, rest - head.val);
        res += process(head.right, rest - head.val);
        return res;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(1);
//        root.right = new TreeNode(-3);
//        root.right.right = new TreeNode(11);
//        System.out.println(pathSum(root, 8));
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }
}
