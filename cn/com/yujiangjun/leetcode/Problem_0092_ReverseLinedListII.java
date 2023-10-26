package cn.com.yujiangjun.leetcode;

import cn.com.yujiangjun.util.LinkedUtil;
import cn.com.yujiangjun.util.ListNode;

public class Problem_0092_ReverseLinedListII {


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        ListNode cur = head;
        ListNode pre = null;
        while (index < left) {
            pre = cur;
            cur = cur.next;
            index++;
        }

        ListNode start = cur;
        ListNode end = null;
        ListNode pre2 = pre;
        while (index >= left && index <= right) {
            end = start;
            ListNode next = start.next;
            start.next = pre2;
            pre2 = start;
            start = next;
            index++;
        }
        cur.next = start;
        if (pre != null) {
            pre.next = pre2;
        }else {
            head=end;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        reverseBetween(root, 2, 4);
        LinkedUtil.print(root);

        System.out.println("============");
        ListNode root2 = new ListNode(3);
//        root2.next = new ListNode(5);
        ListNode reversed = reverseBetween(root2, 1, 1);
        LinkedUtil.print(reversed);
        System.out.println("==============");
    }
}
