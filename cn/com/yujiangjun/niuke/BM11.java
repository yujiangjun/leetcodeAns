package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.LinkedUtil;
import cn.com.yujiangjun.util.ListNode;

public class BM11 {

    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode node1 = reserve(head1);
        ListNode node2 = reserve(head2);
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        int preSum = 0;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val+ preSum;
            cur.next = new ListNode(sum % 10);
            preSum = sum / 10;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            int sum = cur1.val + preSum;
            cur.next = new ListNode(sum % 10);
            preSum = sum / 10;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            int sum = cur2.val+ preSum;
            cur.next = new ListNode(sum % 10);
            preSum = sum / 10;
            cur = cur.next;
            cur2 = cur2.next;
        }
        if (preSum!=0){
            cur.next=new ListNode(preSum);
        }
        return reserve(newHead.next);
    }

    public static ListNode reserve(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            newHead = cur;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(7);

        ListNode node2 = new ListNode(6);
        node2.next = new ListNode(3);
        ListNode node = addInList(node1, node2);
        LinkedUtil.print(node);
    }
}
