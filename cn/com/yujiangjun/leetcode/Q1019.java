package cn.com.yujiangjun.leetcode;

import java.util.*;

public class Q1019 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        List<ListNode> nodes = new ArrayList<>();
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int[] ans = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            while (!stack.isEmpty() && nodes.get(stack.peek()).val < nodes.get(i).val) {
                ans[stack.pop()] = nodes.get(i).val;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        System.out.println(Arrays.toString(nextLargerNodes(head)));
        System.out.println("=====================");

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(5);
        System.out.println(Arrays.toString(nextLargerNodes(head2)));
        System.out.println("=====================");
    }
}
