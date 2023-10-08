package cn.com.yujiangjun.leetcode;

public class Problem_0142_linkedListCycleII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
            if (one==two){
                break;
            }
        }
        if (two == null || two.next == null) {
            return null;
        }
        ListNode t = two.next;
        while (t != two) {
            t = t.next;
            if (t==head){
                return head;
            }
        }
        ListNode t2 = head;
        while (t2 != two) {
            t2 = t2.next;
            two = two.next;
        }
        return two;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode start = new ListNode(2);
        head.next = start;
        start.next = new ListNode(0);
        start.next.next = new ListNode(-4);
        start.next.next.next = start;
        System.out.println(detectCycle(head).val);
        System.out.println("================");

        ListNode head2=new ListNode(1);
        head2.next=new ListNode(2);
        head2.next.next=head2;
        System.out.println(detectCycle(head2).val);

    }
}