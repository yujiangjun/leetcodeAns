package cn.com.yujiangjun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_0105_ConstructBinaryTreeFromPerorderAndInorderTraversal {

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

    public static Map<Integer, Integer> dict = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            dict.put(inorder[i], i);
        }
        return process(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode process(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int indexInOrder = dict.get(preorder[l1]);

        int count = indexInOrder - l2;

        head.left = process(preorder, inorder, l1 + 1, l1 + count, l2, l2 + count - 1);
        head.right = process(preorder, inorder, l1 + count + 1, r1, indexInOrder + 1, r2);

        return head;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode treeNode2 = buildTree(preorder2, inorder2);
        System.out.println("=======================");
    }
}
