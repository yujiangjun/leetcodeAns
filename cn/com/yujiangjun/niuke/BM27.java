package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

import java.util.*;

public class BM27 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(pRoot);
        boolean dict = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            ArrayList<Integer> item = new ArrayList<>();
            if (dict) {
                for (int i = 0; i < size; i++) {
                    cur = queue.pollFirst();
                    item.add(cur.val);
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    cur = queue.pollFirst();
                    item.add(cur.val);
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                }
            }
            dict = !dict;
            ans.add(item);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>> ans = Print(root);
        for (ArrayList<Integer> ret : ans) {
            System.out.println(Arrays.toString(ret.toArray()));
        }
    }
}
