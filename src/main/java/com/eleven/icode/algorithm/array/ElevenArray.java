package com.eleven.icode.algorithm.array;

/**
 * @author by Eleven on 2021/12/29
 */
public class ElevenArray {
    private int length;
    private Object[] data;
    private int index;

    public ElevenArray(int length) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        this.length = length;
        data = new Object[length];
        this.index = 0;
    }

    public void insert(Object obj, int index) {
        checkLength(index);
        for (int i = length - 1; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = obj;
        this.index++;
    }

    private void checkLength(int index) {
        if (index++ >= this.length || this.index + 1 >= this.length) {
            resize(index--);
        }
    }

    private void resize(int index) {
        if (this.length < 128) {
            this.length = this.length << 1;
        } else {
            this.length = this.length + this.length >> 1;
        }
        Object[] tmp = new Object[this.length];
        for (int i = 0; i < data.length; i++) {
            tmp[i] = data[i];
        }
        this.data = tmp;
        checkLength(index);
    }

    public void delete(int index) {
        for (int i = index; i < this.length; i++) {
            if (i != this.length - 1) {
                this.data[i] = this.data[i + 1];
            } else {
                this.data[i] = null;
            }
        }
        this.index--;
    }

    public void update(Object obj, int index) {
        this.data[index] = obj;
    }

    public Object get(int index) {
        return this.data[index];
    }

    private void print() {
        for (Object datum : data) {
            System.out.println("datum: " + datum);
        }
    }

    public static void main(String[] args) {
        ElevenArray array = new ElevenArray(5);
        // for (int i = 0; i < 10; i++) {
        //     array.insert(i, 0);
        // }
        array.insert(12, 12);
        array.print();
    }

}
