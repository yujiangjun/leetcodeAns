package cn.com.yujiangjun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_0155_MinStack {

    public static class MinStack {

        int size;
        List<Integer> list;
        PriorityQueue<Integer> queue;
        public MinStack() {
            size=0;
            list=new ArrayList<>();
            queue=new PriorityQueue<>();
        }

        public void push(int val) {
            list.add(val);
            size++;
            queue.add(val);
        }

        public void pop() {
            Integer i = list.get(size - 1);
            list.remove(size-1);
            size--;
            queue.remove(i);
        }

        public int top() {
            return list.get(size-1);
        }

        public int getMin() {
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
