package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BM39 {

    public static String Serialize(TreeNode root) {
        List<String> path = new ArrayList<>();
        String ans = "";
        if (root == null) {
            return ans;
        }
        process(root, path);
        for (int i = 0; i < path.size() - 1; i++) {
            ans += path.get(i) + ",";
        }
        ans += path.get(path.size() - 1);
        return ans;
    }

    public static void process(TreeNode head, List<String> path) {
        if (head == null) {
            path.add("#");
            return;
        }
        path.add(String.valueOf(head.val));
        process(head.left, path);
        process(head.right, path);
    }


    public static TreeNode Deserialize(String str) {
        if (str==null||str.isEmpty()){
            return null;
        }
        List<String> nodes = Stream.of(str.split(",")).collect(Collectors.toList());
        return dProcess(nodes);
    }

    public static TreeNode dProcess(List<String> path) {
        if (Objects.equals("#", path.get(0))) {
            path.remove(0);
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(path.get(0)));
        path.remove(0);
        TreeNode left = dProcess(path);
        TreeNode right = dProcess(path);
        head.left = left;
        head.right = right;
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        String serialize = Serialize(root);
        System.out.println(serialize);

        TreeNode head = Deserialize(serialize);
        System.out.println("");
    }
}
