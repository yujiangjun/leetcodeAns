package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;
import cn.com.yujiangjun.util.TreeUtil;

public class BM33 {


    public static TreeNode Mirror(TreeNode pRoot) {
        // write code here
        return process(pRoot);
    }

    public static TreeNode process(TreeNode head) {
        if (head == null) {
            return null;
        }
        process(head.left);
        process(head.right);
        TreeNode t = head.right;
        head.right = head.left;
        head.left = t;
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left=new TreeNode(6);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(11);
        System.out.println("before invoke");
        TreeUtil.levelPrint(root);
        System.out.println("after invoke");
        TreeNode mirror = Mirror(root);
        TreeUtil.levelPrint(mirror);
    }
}
