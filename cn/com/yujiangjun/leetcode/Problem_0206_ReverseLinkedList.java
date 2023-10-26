package cn.com.yujiangjun.leetcode;

public class Problem_0206_ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            reverseHead = cur;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return reverseHead;
    }

    public static ListNode reverseListByRecurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode reverseHead = reverseListByRecurse(next);
        next.next = head;
        return reverseHead;
    }
    public static ListNode reverseByRecurse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = reverseListByRecurse(head);
        head.next=null;
        return reversed;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "=>");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        printList(root);
        ListNode reverseList = reverseList(root);
        System.out.println("非递归方式");
        printList(reverseList);
        System.out.println("递归方式");
        ListNode reverseListByRecurse = reverseByRecurse(reverseList(reverseList));
        printList(reverseListByRecurse);
    }
}
