package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BM40 {


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
        int[] pre={3,9,20,15,7};
        int[] in={9,3,15,20,7};
        TreeNode head = reConstructBinaryTree(pre, in);
        System.out.println("");
    }
}
