package cn.com.yujiangjun.leetcode;

public class Problem_0114_FlattenBinaryTreeToLinkedList {


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

    public static class Info {
        public TreeNode head;
        public TreeNode tail;

        public Info(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root);
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return null;
        }
        Info left = process(head.left);
        Info right = process(head.right);
        head.left = null;
        head.right = left == null ? null : left.head;
        TreeNode tail = left == null ? head : left.tail;
        tail.right = right == null ? null : right.head;
        tail = right == null ? tail : right.tail;
        return new Info(head, tail);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        flatten(root);
        System.out.println("===============");
    }
}
