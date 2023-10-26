package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

import java.util.*;

public class BM41 {

    public static int[] solve(int[] preOrder, int[] inOrder) {
        // write code here
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        if (root == null) {
            return new int[]{};
        }
        Map<Integer, Integer> mostRightNodeMap = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int maxDepth = -1;
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode cur = nodeStack.pop();
            Integer depth = depthStack.pop();
            if (cur == null) {
                continue;
            }
            maxDepth = Math.max(maxDepth, depth);
            if (!mostRightNodeMap.containsKey(depth)) {
                mostRightNodeMap.put(depth, cur.val);
            }
            nodeStack.push(cur.left);
            nodeStack.push(cur.right);
            depthStack.push(depth + 1);
            depthStack.push(depth + 1);
        }
        int size = mostRightNodeMap.size();
        int[] ans = new int[size];
        int i = 0;
        for (Integer value : mostRightNodeMap.values()) {
            ans[i++] = value;
        }
        return ans;
    }

    public static int[] solve2(int[] preOrder, int[] inOrder) {
        // write code here
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        if (root == null) {
            return new int[]{};
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    ans.add(cur.val);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
            }
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    public static TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        // write code here
        if (preOrder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < vinOrder.length; i++) {
            inOrderMap.put(vinOrder[i], i);
        }
        return process(preOrder, 0, 0, vinOrder.length - 1, inOrderMap);
    }

    /**
     * @param preOrder
     * @param root       在前序遍历位置
     * @param left       中序遍历中的left
     * @param right      中序遍历的right
     * @param inOrderMap
     * @return
     */
    public static TreeNode process(int[] preOrder, int root, int left, int right,
                                   Map<Integer, Integer> inOrderMap) {
        if (left > right) {
            return null;
        }
        TreeNode head = new TreeNode(preOrder[root]);
        int headInOderIndex = inOrderMap.get(preOrder[root]);
        int leftSize = headInOderIndex - left;
        TreeNode leftNode = process(preOrder, root + 1, left, headInOderIndex - 1, inOrderMap);
        TreeNode rightNode = process(preOrder, root + leftSize + 1, headInOderIndex + 1, right, inOrderMap);
        head.left = leftNode;
        head.right = rightNode;
        return head;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3};
        int[] in = {4, 2, 5, 1, 3};
        System.out.println(Arrays.toString(solve(pre, in)));
        System.out.println(Arrays.toString(solve2(pre, in)));
    }
}
