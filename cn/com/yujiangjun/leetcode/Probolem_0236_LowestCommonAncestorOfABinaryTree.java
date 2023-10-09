package cn.com.yujiangjun.leetcode;

public class Probolem_0236_LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode ans;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        process(root, p, q);
        return ans;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (p.val == root.val || q.val == root.val)) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public boolean process(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) {
            return false;
        }
        boolean lson = process(head.left, p, q);
        boolean rson = process(head.right, p, q);
        if ((lson && rson) || ((p.val == head.val || q.val == head.val)) && (lson || rson)) {
            ans = head;
        }
        return lson || rson || (head.val == p.val || head.val == q.val);
    }
}
