package cn.com.yujiangjun.leetcode;

import cn.com.yujiangjun.leetcode.util.LinkedUtil;
import cn.com.yujiangjun.leetcode.util.ListNode;

public class Problem_0025_ReverseNodesInKGroup {

    public static ListNode[] reverseBetween(ListNode head, int left, int right) {
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
        } else {
            head = end;
        }
        return new ListNode[]{head, cur};
    }

    public static ListNode reserveKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cout = 0;
        int left = 0;
        int right = 0;
        while (cur != null) {
            cout++;
            right++;
            if (k == cout) {
                ListNode[] nodes = reverseBetween(head, left + 1, right);
                head = nodes[0];
                cur = nodes[1];
                cout = 0;
                left = right;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode head = reserveKGroup(root, 2);
        LinkedUtil.print(head);
        System.out.println("==================");
    }
}
