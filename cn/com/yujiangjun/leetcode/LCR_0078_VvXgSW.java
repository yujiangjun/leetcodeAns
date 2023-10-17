package cn.com.yujiangjun.leetcode;

import cn.com.yujiangjun.leetcode.util.LinkedUtil;
import cn.com.yujiangjun.leetcode.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LCR_0078_VvXgSW {


    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list!=null){
                queue.add(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()){
            ListNode next=queue.poll();
            cur.next=next;
            cur=cur.next;
            if (next.next!=null){
                queue.add(next.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next=new ListNode(4);
        head1.next.next=new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next=new ListNode(3);
        head2.next.next=new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next=new ListNode(6);

        ListNode newHead = mergeKLists(new ListNode[]{head1, head2, head3});
        LinkedUtil.print(newHead);
        System.out.println("================");
    }
}
