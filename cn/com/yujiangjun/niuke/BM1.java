package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.LinkedUtil;
import cn.com.yujiangjun.util.ListNode;

public class BM1 {

    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode reserveHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            reserveHead = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reserveHead;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        ListNode reversed = ReverseList(root);
        LinkedUtil.print(reversed);
    }
}
