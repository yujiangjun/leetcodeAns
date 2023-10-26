package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.LinkedUtil;
import cn.com.yujiangjun.util.ListNode;

public class BM2 {


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        int index = 1;
        ListNode cur = head;
        while (cur != null) {
            if (index == m) {
                break;
            }
            pre = cur;
            cur = cur.next;
            index++;
        }
        ListNode cur2 = cur;
        ListNode reverseHead = null;
        ListNode pre2 = pre;
        while (cur2 != null) {

            reverseHead = cur2;
            ListNode next = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = next;
            if (index == n) {
                break;
            }
            index++;
        }
        if (cur != null) {
            cur.next = cur2;
        }
        if (pre != null) {
            pre.next = reverseHead;
        }
        return pre == null ? reverseHead : head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(5);
        ListNode reversed = reverseBetween(root,1,5);
        LinkedUtil.print(reversed);
    }
}
