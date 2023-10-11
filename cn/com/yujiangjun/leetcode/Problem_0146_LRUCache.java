package cn.com.yujiangjun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_0146_LRUCache {

    private MyCache<Integer, Integer> myCache;

    public Problem_0146_LRUCache(int capacity) {
        myCache = new MyCache<>(capacity);
    }

    public int get(int key) {
        Integer ans = myCache.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        myCache.put(key,value);
    }

    private class CacheNode<K, V> {
        public K k;
        public V v;
        public CacheNode<K, V> pre;
        public CacheNode<K, V> next;

        public CacheNode(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }


    private class NodeDoubleLinkedList<K, V> {
        private CacheNode<K, V> head;
        private CacheNode<K, V> tail;

        public void addNewNode(CacheNode<K, V> newNode) {
            if (newNode==null){
                return;
            }
            if (head==null){
                head=newNode;
                tail=newNode;
            }else {
                newNode.pre=tail;
                tail.next=newNode;
                tail=newNode;
            }
        }

        public void moveNode2Tail(CacheNode<K, V> node) {
            if (node==tail){
                return;
            }
            if (head==node){
                head=head.next;
                head.pre=null;
            }else {
                node.pre.next=node.next;
                node.next.pre=node.pre;
            }

            node.pre=tail;
            node.next=null;
            tail.next=node;
            tail=node;
        }

        public CacheNode<K, V> removeHead() {
            if (head==null){
                return null;
            }
            CacheNode<K,V> ans = head;
            if (head==tail){
                head=null;
                tail=null;
            }else {
                head=head.next;
                ans.next=null;
                head.pre=null;
            }
            return ans;
        }
    }


    private class MyCache<K, V> {
        int capacity;
        Map<K, CacheNode<K, V>> map;

        NodeDoubleLinkedList<K, V> linkedList;

        public MyCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            linkedList = new NodeDoubleLinkedList<>();
        }


        public V get(K k) {
            if (map.containsKey(k)) {
                CacheNode<K, V> ans = map.get(k);
                linkedList.moveNode2Tail(ans);
                return ans.v;
            }
            return null;
        }

        public void put(K k, V v) {
            if (map.containsKey(k)) {
                CacheNode<K, V> node = map.get(k);
                node.v = v;
                linkedList.moveNode2Tail(node);
            } else {
                CacheNode<K, V> newNode = new CacheNode<>(k, v);
                map.put(k, newNode);
                linkedList.addNewNode(newNode);
                if (capacity + 1 == map.size()) {
                    removeMostUnUsedCache();
                }
            }
        }

        private void removeMostUnUsedCache(){
            CacheNode<K, V> head = linkedList.removeHead();
            map.remove(head.k);
        }
    }

    public static void main(String[] args) {
        Problem_0146_LRUCache cache = new Problem_0146_LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
