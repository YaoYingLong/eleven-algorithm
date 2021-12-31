package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/3
 */
public class HeapSort {

    public void heapSortAsc(Integer[] arr) {
        int len = arr.length;
        // len / 2 - 1表示的是从完全二叉数中最后一个元素的父节点开始堆化
        for (int start = len / 2 - 1; start >= 0; start--) {
            maxHeapDown(arr, start, len);  // 将树中最大的元素排到堆顶，且每颗子树都是一个
        }
        // 上面的循环只是将最大的元素排到了堆顶，但是整棵树即数组中的元素不是有序的
        // 每一次将对顶的元素即最大的元素，和未排序的最后一个元素交换，再进行一次堆化，这样就将数据从小到大排序了
        for (int index = len - 1; index > 0; index--) {
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
            maxHeapDown(arr, 0, index); // len~i已经排好序了
        }
    }

    /**
     * 将完全二叉树中最大的元素放到堆顶，end表示最多建到的点
     */
    public void maxHeapDown(Integer[] arr, int start, int end) {
        int parent = start;
        int left = parent * 2 + 1; // 找到当前节点的左子节点位置
        while (left < end) {
            int max = left; // max表示左右节点大的那一个在数组中的位置
            if (left + 1 < end && arr[left] < arr[left + 1]) { // 比较左右节点和父节点的大小
                max = left + 1; // 若右节点比左节点大，则将父节点和右节点交换
            }
            // 若左节点比右节点大，则将父节点和左节点交换
            if (arr[parent] > arr[max]) { // 若父节点大于子节点中最大的那一个，则退出
                return;
            } else { // 若父节点小于子节点中最大的那一个，则交换
                int tmp = arr[parent];
                arr[parent] = arr[max];
                arr[max] = tmp;
                parent = max;   // 还原指针，交换数据后，max指向的是被交换下来的父节点，还需要往下遍历，故需要将parent指向需要遍历的数据
                left = parent * 2 + 1;  // 找到之前左右节点大的节点的左子节点在数组中的索引位置
            }
        }
    }

    public void heapSortDesc(Integer[] arr) {
        int len = arr.length;
        for (int start = len / 2 - 1; start >= 0; start--) {
            minHeapDown(arr, start, len);
        }

        for (int index = len - 1; index > 0; index--) {
            int tmp = arr[0];
            arr[0] = arr[index];
            arr[index] = tmp;
            minHeapDown(arr, 0, index);
        }
    }

    public void minHeapDown(Integer[] arr, int start, int end) {
        int parent = start;
        int left = 2 * start + 1; // 找到当前节点的左子节点位置
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
            left = 2 * parent + 1;  // 找到之前左右节点小的节点的左子节点在数组中的索引位置
        }
    }

    @Test
    public void InsertSortTest() {
        {
            Integer[] arr = new Integer[]{8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
            System.err.println("before:" + Arrays.asList(arr));
            heapSortAsc(arr);
            System.err.println(" after:" + Arrays.asList(arr));
        }
        {
            Integer[] arr = new Integer[]{8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
            System.err.println("before:" + Arrays.asList(arr));
            heapSortDesc(arr);
            System.err.println(" after:" + Arrays.asList(arr));
        }
    }
}
