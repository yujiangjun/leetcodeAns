package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BM26 {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            TreeNode cur = null;
            ArrayList<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur=queue.poll();
                item.add(cur.val);
                if (cur.left!=null){
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                }
            }
            ans.add(item);
        }
        return ans;
    }
}
