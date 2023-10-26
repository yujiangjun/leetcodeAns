package cn.com.yujiangjun.leetcode;

import cn.com.yujiangjun.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem_0337_HouseRobberIII {

    public static int rob(TreeNode root) {
        return process(root);
    }


    public static int process(TreeNode head) {
        if (head == null) {
            return 0;
        }

        // p1 使用head
        int p1 = head.val;
        if (head.left != null) {
            p1 += process(head.left.left) + process(head.left.right);
        }
        if (head.right != null) {
            p1 += process(head.right.left) + process(head.right.right);
        }
        int p2 = process(head.left) + process(head.right);
        return Math.max(p1, p2);
    }

    public static int rob2(TreeNode root) {
        Map<TreeNode, Integer> dp = new HashMap<>();
        return process2(root,dp);
    }


    public static int process2(TreeNode head, Map<TreeNode, Integer> dp) {
        if (dp.containsKey(head)) {
            return dp.get(head);
        }
        int ans = 0;
        if (head != null) {
            // p1 使用head
            int p1 = head.val;
            if (head.left != null) {
                p1 += process2(head.left.left, dp) + process2(head.left.right, dp);
            }
            if (head.right != null) {
                p1 += process2(head.right.left, dp) + process2(head.right.right, dp);
            }
            int p2 = process2(head.left, dp) + process2(head.right, dp);
            ans = Math.max(p1, p2);
        }
        dp.put(head, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
        System.out.println(rob2(root));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right = new TreeNode(5);
        root2.right.right = new TreeNode(1);
        System.out.println(rob(root2));
        System.out.println(rob2(root2));
    }
}
