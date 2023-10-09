package cn.com.yujiangjun.leetcode;

public class Problem_0226_InvertBinaryTree {

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

    public static TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    public static void process(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode t = head.left;
        head.left = head.right;
        head.right = t;
        process(head.left);
        process(head.right);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left=new TreeNode(2);
//        root.left.left=new TreeNode(1);
//        root.left.right=new TreeNode(3);
//
//        root.right=new TreeNode(7);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(9);
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        invertTree(root);
        System.out.println("==============");
    }
}
