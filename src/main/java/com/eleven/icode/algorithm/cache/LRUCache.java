package com.eleven.icode.algorithm.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by YingLong on 2022/1/10
 */
public class LRUCache<K, V> {
    private int cacheCapacity;
    private Map<K, CacheNode> existNodeMap;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        existNodeMap = new HashMap<>(this.cacheCapacity);
    }

    public void put(K key, V value) {
        CacheNode node = existNodeMap.get(key);
        if (node == null) {
            if (this.existNodeMap.size() >= this.cacheCapacity) {
                this.existNodeMap.remove(tail.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = key;
        }
        node.value = value;
        moveToFirst(node);
        existNodeMap.put(key, node);
    }

    public Object get(K key) {
        CacheNode node = existNodeMap.get(key);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node;
    }

    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
        }
    }

    public Object remove(K key) {
        CacheNode node = existNodeMap.get(key);
        if (node == null) {
            return null;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
        return existNodeMap.remove(key);
    }

    public void clear() {
        this.cacheCapacity = 0;
        this.existNodeMap.clear();
    }

    private void moveToFirst(CacheNode node) {
        if (node == head) {
            return;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
        if (head == null || tail == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        head.prev = null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        CacheNode node = head;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.put(1, "a");
        System.out.println(lru);
        lru.put(2, "b");
        System.out.println(lru);
        lru.put(3, "c");
        System.out.println(lru);
        lru.put(4, "d");
        System.out.println(lru);
        lru.put(1, "aa");
        System.out.println(lru);
        lru.put(2, "bb");
        System.out.println(lru);
        lru.put(5, "e");
        System.out.println(lru);
        lru.get(1);
        System.out.println(lru);
        lru.remove(11);
        System.out.println(lru);
        lru.remove(1);
        System.out.println(lru);
        lru.put(1, "aaa");
        System.out.println(lru);
        lru.put(1, "a1");
        System.out.println(lru);
        lru.put(1, "a2");
        System.out.println(lru);
    }
}
