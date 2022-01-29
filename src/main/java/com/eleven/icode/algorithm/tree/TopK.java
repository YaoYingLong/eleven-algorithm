package com.eleven.icode.algorithm.tree;

import java.util.Arrays;
import java.util.Random;

public class TopK {
    private final int topK = 10;
    private final int[] data = new int[topK];

    public void topK() {
        Random r = new Random();
        long time = System.currentTimeMillis();
        int size = 0;
        boolean init = false;
        for (int i = 0; i < 100000000; i++) {
            int num = r.nextInt(1000000000);
            if (size < topK) {
                data[size] = num;
                size++;
            } else {
                if (!init) { // 初始化堆，这里我们只需要初始化一次就可以了
                    for (int j = topK / 2 - 1; j >= 0; j--) {
                        minHeap(0, topK);
                    }
                    init = true;
                }
                if (num > data[0]) { // 小顶堆那么堆顶是最小的，如果当前的数比堆顶大，则替换堆顶，然后做一次堆化
                    data[0] = num;
                    minHeap(0, topK);
                }
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - time) + "ms");
        System.out.println(Arrays.toString(data));
    }

    public void minHeap(int start, int end) { // 构建一个小顶堆 从上往下构建
        int parent = start;
        int left = (start << 1) + 1; // 找到当前节点的左子节点位置
        while (left < end) {
            int min = left; // min表示左右节点小的那一个在数组中的位置
            if (left + 1 < end && data[left] > data[left + 1]) {
                min = left + 1;
            }
            if (data[min] > data[parent]) {  // 比较左右节点中小的那一个和父节点的大小
                break;  // 若小的那个节点都比父节点大，说明不需要再遍历了
            }
            int tmp = data[min];
            data[min] = data[parent];
            data[parent] = tmp;
            parent = min;   // 还原指针，交换数据后，min指向的是被交换下来的父节点，还需要往下遍历，故需要将parent指向需要遍历的数据
            left = (parent << 1) + 1;  // 找到之前左右节点小的节点的左子节点在数组中的索引位置
        }
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        topK.topK();
    }
}
