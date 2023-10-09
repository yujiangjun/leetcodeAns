package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Problem_0297_SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static String serialize(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return "";
        }
        rserialize(root, ans);
        String s = "";
        for (int i = 0; i < ans.size() - 1; i++) {
            s += ans.get(i) + ",";
        }
        s += ans.get(ans.size() - 1);
        return s;
    }

    public static void rserialize(TreeNode head, List<String> path) {
        if (head == null) {
            path.add("null");
            return;
        }
        path.add(String.valueOf(head.val));
        rserialize(head.left, path);
        rserialize(head.right, path);
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data==null||data.isEmpty()){
            return null;
        }
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return rdeserialize(list);
    }

    public static TreeNode rdeserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        head.left = rdeserialize(list);
        head.right = rdeserialize(list);
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = deserialize(serialize);
        System.out.println("===============");
    }
}
