package com.eleven.icode.algorithm.linkedList;

/**
 * @author by Eleven on 2021/12/29
 */
public interface ElevenList<E> {
    void add(E e);

    void remove(int i);

    void remove(Object e);

    E get(int i);

    int size();

    boolean isEmpty();
}
