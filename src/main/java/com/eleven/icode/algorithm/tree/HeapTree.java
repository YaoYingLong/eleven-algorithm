package com.eleven.icode.algorithm.tree;

import java.util.Arrays;

/**
 * @author by YingLong on 2022/1/2
 */
public class HeapTree {

    private int size;
    private Integer[] data;

    public HeapTree(Integer[] arr) {
        size = arr.length;
        data = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                throw new IllegalArgumentException();
            }
            data[i] = arr[i];
        }
        int len = data.length;
        // len / 2 - 1表示的是从完全二叉数中最后一个元素的父节点开始堆化
        for (int i = (len >> 1) - 1; i >= 0; i--) {    // o(nlgn)
            maxHeapDown(i, len);  // 将树中最大的元素排到堆顶
        }
    }

    public void add(Integer element) {
        if (size + 1 >= data.length) {
            grow();
        }
        int index = size++;
        if (index != 0) {
            while (index > 0) {
                int parent = index - 1 >> 1;
                Integer e = data[parent];
                if (e >= element) {
                    break;
                }
                data[index] = e;
                index = parent;
            }
            data[index] = element;
        }
    }

    public void deleteByIndex(int index) {
        if (index > size) {
            throw new IllegalArgumentException();
        }
        int last = --size;
        data[index] = data[last];
        data[last] = null;
        if (index < last) {
            maxHeapDown(index, size);
        }
    }

    private void grow() {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity << 1;
        data = Arrays.copyOf(data, newCapacity);
    }

    /**
     * 将完全二叉树中最大的元素放到堆顶，end表示最多建到的点
     */
    public void maxHeapDown(int start, int end) {
        int parent = start;
        int left = (parent << 1) + 1; // 找到当前节点的左子节点位置
        while (left < end) {
            int max = left; // max表示左右节点大的那一个在数组中的位置
            if (left + 1 < end && data[left] < data[left + 1]) { // 比较左右节点和父节点的大小
                max = left + 1; // 若右节点比左节点大，则将父节点和右节点交换
            }
            // 若左节点比右节点大，则将父节点和左节点交换
            if (data[parent] > data[max]) { // 若父节点大于子节点中最大的那一个，则退出
                return;
            } else { // 若父节点小于子节点中最大的那一个，则交换
                int tmp = data[parent];
                data[parent] = data[max];
                data[max] = tmp;
                parent = max;   // 还原指针，交换数据后，max指向的是被交换下来的父节点，还需要往下遍历，故需要将parent指向需要遍历的数据
                left = (parent << 1) + 1;  // 找到之前左右节点大的节点的左子节点在数组中的索引位置
            }
        }
    }

    public void minHeapDown(Integer[] arr, int start, int end) {
        int parent = start;
        int left = (start << 1) + 1; // 找到当前节点的左子节点位置
        while (left < end) {
            int min = left; // min表示左右节点小的那一个在数组中的位置
            if (left + 1 < end && arr[left] > arr[left + 1]) {
                min = left + 1;
            }
            if (arr[min] > arr[parent]) {  // 比较左右节点中小的那一个和父节点的大小
                break;  // 若小的那个节点都比父节点大，说明不需要再遍历了
            }
            int tmp = arr[min];
            arr[min] = arr[parent];
            arr[parent] = tmp;
            parent = min;   // 还原指针，交换数据后，min指向的是被交换下来的父节点，还需要往下遍历，故需要将parent指向需要遍历的数据
            left = (parent << 1) + 1;  // 找到之前左右节点小的节点的左子节点在数组中的索引位置
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{15, 26, 12, 10, 5, 8};
        HeapTree heapTree = new HeapTree(data);
        for (int i = 0; i < heapTree.data.length; i++) {
            System.out.print(heapTree.data[i] + " ");
        }
        System.out.println();
        heapTree.add(30);
        for (int i = 0; i < heapTree.data.length; i++) {
            System.out.print(heapTree.data[i] + " ");
        }
        System.out.println();
        heapTree.add(22);
        for (int i = 0; i < heapTree.data.length; i++) {
            System.out.print(heapTree.data[i] + " ");
        }
        System.out.println();
        heapTree.add(16);
        for (int i = 0; i < heapTree.data.length; i++) {
            System.out.print(heapTree.data[i] + " ");
        }
        System.out.println();
        heapTree.deleteByIndex(5);
        for (int i = 0; i < heapTree.data.length; i++) {
            System.out.print(heapTree.data[i] + " ");
        }
        System.out.println();
    }
}
