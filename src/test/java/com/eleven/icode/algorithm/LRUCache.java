package com.eleven.icode.algorithm;

import com.eleven.icode.algorithm.cache.CacheNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by YingLong on 2022/3/4
 */
public class LRUCache {
    public int capacity;
    public Map<Integer, CacheNode> cache;
    public CacheNode head;
    public CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
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
        LRUCache lru = new LRUCache(3);
        lru.put(1, 1);
        System.out.println(lru);
        lru.put(2, 2);
        System.out.println(lru);
        lru.put(3, 3);
        System.out.println(lru);
        lru.put(4, 4);
        System.out.println(lru);
        lru.put(1, 1);
        System.out.println(lru);
        lru.put(2, 2);
        System.out.println(lru);
        lru.put(5, 5);
        System.out.println(lru);
        lru.get(1);
        System.out.println(lru);
        lru.put(1, 11);
        System.out.println(lru);
        lru.put(1, 111);
        System.out.println(lru);
        lru.put(1, 1111);
        System.out.println(lru);
    }
}
