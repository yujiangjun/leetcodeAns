package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

public class BM38 {

    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        TreeNode process = process(root, o1, o2);
        return process == null ? -1 : process.val;
    }

    public static TreeNode process(TreeNode head, int o1, int o2) {
        if (head == null || (head.val == o1 || head.val == o2)) {
            return head;
        }
        TreeNode left = process(head.left, o1, o2);
        TreeNode right = process(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
