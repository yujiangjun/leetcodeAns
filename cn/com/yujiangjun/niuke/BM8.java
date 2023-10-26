package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.ListNode;

public class BM8 {

    public static ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        for (int i = 0; i < k; i++) {
            if (fast==null){
                return null;
            }
            fast=fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode node2 = FindKthToTail(node, 5);
        System.out.println(node2 == null ? null : node2.val);

        ListNode node3 = new ListNode(1);
        ListNode node4 = FindKthToTail(node3, 8);
        System.out.println(node4 == null ? null : node4.val);
    }
}
