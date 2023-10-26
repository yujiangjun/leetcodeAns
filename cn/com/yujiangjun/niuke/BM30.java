package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

public class BM30 {

    public static TreeNode convert(TreeNode pRootTree) {
        if (pRootTree == null) {
            return null;
        }
        return process(pRootTree)[0];
    }

    public static TreeNode[] process(TreeNode head) {
        if (head == null) {
            return new TreeNode[]{};
        }
        TreeNode[] pre = process(head.left);
        TreeNode[] next = process(head.right);
        if (pre.length == 2) {
            head.left = pre[1];
            pre[1].right = head;
        }
        if (next.length == 2) {
            head.right = next[0];
            next[0].left = head;
        }
        TreeNode[] ans = new TreeNode[2];
        ans[0] = pre.length == 2 ? pre[0] : head;
        ans[1] = next.length == 2 ? next[1] : head;
        return ans;
    }

    public static void print(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        TreeNode head = convert(root);
        print(head);
    }
}
