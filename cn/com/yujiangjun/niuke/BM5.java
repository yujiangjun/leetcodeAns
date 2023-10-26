package cn.com.yujiangjun.niuke;

import cn.com.yujiangjun.util.LinkedUtil;
import cn.com.yujiangjun.util.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BM5 {

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i)!=null){
                queue.add(lists.get(i));
            }

        }
        if (queue.isEmpty()){
            return null;
        }
        ListNode root = null;
        root = queue.poll();
        ListNode cur = root;
        if (cur.next != null) {
            queue.add(cur.next);
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(7);
        list.add(node);
        list.add(node1);
        ListNode node2 = mergeKLists(list);
        LinkedUtil.print(node2);
    }
}
