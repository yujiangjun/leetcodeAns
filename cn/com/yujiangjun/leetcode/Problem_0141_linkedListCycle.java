package cn.com.yujiangjun.leetcode;

public class Problem_0141_linkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (two != null && two.next != null && one != two) {
            one = one.next;
            two = two.next.next;
        }
        return two != null && two.next != null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode start = new ListNode(2);
        head.next = start;
        start.next = new ListNode(0);
        start.next.next = new ListNode(-4);
        start.next.next.next = start;
        System.out.println(hasCycle(head));
    }
}