package com.eleven.icode.algorithm.cache;

/**
 * @author by YingLong on 2022/1/10
 */
public class CacheNode {
    public CacheNode prev;
    public CacheNode next;
    public Object key;
    public Object value;

    public CacheNode getPrev() {
        return prev;
    }

    public void setPrev(CacheNode prev) {
        this.prev = prev;
    }

    public CacheNode getNext() {
        return next;
    }

    public void setNext(CacheNode next) {
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
