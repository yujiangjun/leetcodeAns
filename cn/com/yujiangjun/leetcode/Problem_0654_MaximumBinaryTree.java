package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0654_MaximumBinaryTree {


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

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        TreeNode[] nodes = new TreeNode[n];
        int[] right = new int[n];// i位置右边第一个比i位置的数大的位置
        int[] left = new int[n];// i位置左边第一个比i位置的数大的位置
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (left[i] == -1 && right[i] == -1) {
                root = nodes[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                nodes[left[i]].right = nodes[i];
            } else {
                nodes[right[i]].left = nodes[i];
            }
        }
        return root;
    }

    public static TreeNode constructMaximumBinaryTree2(int[] nums) {
        int n = nums.length;
        List<Integer> stack = new ArrayList<>();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.get(stack.size() - 1)]) {
                nodes[i].left = nodes[stack.get(stack.size() - 1)];
                stack.remove(stack.size() - 1);
            }
            if (!stack.isEmpty()) {
                nodes[stack.get(stack.size() - 1)].right = nodes[i];
            }
            stack.add(i);
        }
        return nodes[stack.get(0)];
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 6, 0, 5};
        int[] nums = {3, 2, 1};
//        int[] nums = {1, 2, 3};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println("========================");
    }
}
