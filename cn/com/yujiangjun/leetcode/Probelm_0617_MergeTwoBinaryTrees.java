package cn.com.yujiangjun.leetcode;

public class Probelm_0617_MergeTwoBinaryTrees {

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

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode cur;
        if (root1 == null) {
            cur = root2;
        } else if (root2 == null) {
            cur = root1;
        } else {
            root1.val += root2.val;
            cur = root1;
        }
        cur.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        cur.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return cur;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left=new TreeNode(3);
        root1.left.left=new TreeNode(5);
        root1.right=new TreeNode(2);

        TreeNode root2=new TreeNode(2);
        root2.left=new TreeNode(1);
        root2.left.right=new TreeNode(4);
        root2.right=new TreeNode(3);
        root2.right.right=new TreeNode(7);
        TreeNode treeNode = mergeTrees(root1, root2);
        System.out.println("=====================");
    }
}
