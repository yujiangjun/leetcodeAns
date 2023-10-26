package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.ListNode;

public class BM9 {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode fast = head;
        ListNode cur = head;
        ListNode pre=null;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            pre=cur;
            cur = cur.next;
        }
        if (cur==head){
            return head.next;
        }
        pre.next=cur.next;
        return head;
    }
}
