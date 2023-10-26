package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.LinkedUtil;
import cn.com.yujiangjun.util.ListNode;

public class BM14 {

    public static ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenStart = head.next;
        ListNode start1 = head;
        ListNode start2 = evenStart;
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            odd = odd.next.next;
            start1.next = odd;
            start1 = start1.next;
            even = even.next.next;
            start2.next = even;
            start2 = start2.next;
        }
        start1.next = evenStart;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
        ListNode node1 = oddEvenList(node);
        LinkedUtil.print(node1);
    }
}
