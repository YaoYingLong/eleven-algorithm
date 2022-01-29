package com.eleven.icode.algorithm.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] data = new int[]{8, 4, 20, 7, 3, 1, 25, 14, 17};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void maxHeap(int[] data, int start, int end) { // 建一个大顶堆,end表示最多建到的点 lgn
        int parent = start;
        int left = parent * 2 + 1; // 下标是从0开始的就要加1，从1就不用
        while (left < end) {
            int max = left; // max表示左右节点大的那一个
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
                left = parent * 2 + 1;  // 找到之前左右节点大的节点的左子节点在数组中的索引位置
            }
        }
    }

    public static void heapSort(int[] data) {
        int len = data.length;
        // len / 2 - 1表示的是从完全二叉数中最后一个元素的父节点开始堆化
        for (int i = len / 2 - 1; i >= 0; i--) {    // o(nlgn)
            maxHeap(data, i, len);  // 将树中最大的元素排到堆顶
        }
        // 上面的循环只是将最大的元素排到了堆顶，但是整棵树即数组中的元素不是有序的
        // 每一次将对顶的元素即最大的元素，和未排序的最后一个元素交换，再进行一次堆化，这样就将数据从小到大排序了
        for (int i = len - 1; i > 0; i--) {        // o(nlgn)
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeap(data, 0, i);    // len~i已经排好序了
        }
    }
}
