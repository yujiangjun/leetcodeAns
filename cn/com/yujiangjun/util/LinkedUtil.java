package cn.com.yujiangjun.util;

public class LinkedUtil {


    public static void print(ListNode head){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "=>");
            cur = cur.next;
        }
        System.out.println();
    }
}
