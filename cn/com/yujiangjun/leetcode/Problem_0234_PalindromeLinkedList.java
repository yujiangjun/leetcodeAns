package cn.com.yujiangjun.leetcode;

public class Problem_0234_PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode halfEnd = endOfFirstHalf(head);
        ListNode reserveSecondHalfStart = reserve(halfEnd.next);
        boolean ans = true;
        ListNode c1 = head;
        ListNode c2 = reserveSecondHalfStart;
        while (ans && c2 != null) {
            if (c1.val != c2.val) {
                ans = false;
                break;
            }
            c1=c1.next;
            c2=c2.next;
        }
        reserve(reserveSecondHalfStart);
        return ans;
    }


    public static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reserve(ListNode head) {
        ListNode cur = head;
        ListNode reserveHead = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                reserveHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reserveHead;
    }

    public static ListNode process(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode reserveHead = process(next);
        next.next = head;
        return reserveHead;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
