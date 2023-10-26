package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

public class BM31 {

    public boolean isSymmetrical(TreeNode pRoot) {
        // write code here
        return process(pRoot, pRoot);
    }

    public static boolean process(TreeNode head1, TreeNode head2) {
        // write code here
        if (head1==null&& head2==null) {
            return true;
        }
        if (head1 != null && head2 != null) {
            return head1.val == head2.val && process(head1.left, head2.right) && process(head1.right, head2.left);
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
