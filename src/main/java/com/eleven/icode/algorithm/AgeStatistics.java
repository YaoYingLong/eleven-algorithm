package com.eleven.icode.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author by Eleven on 2021/12/29
 */
public class AgeStatistics {
    public static void main(String[] args) throws Exception {
        String fileName = "E:\\IData\\test\\age1.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(isr);
        int total = 0;    //21亿
        int data[] = new int[200];
        String str;
        while ((str = br.readLine()) != null) {  //一行一行的读 O(n)
            int age = Integer.parseInt(str);
            data[age]++;
            total++;
        }
        //O(n) 14亿. 100万/秒 *1000 = 10亿 100~1000s之间 => 500s以下 60*8=480s
        System.out.println("总共的数据大小: " + total);
        for (int i = 0; i < 200; i++) { //下标从0开始的
            System.out.println(i + ":" + data[i]);
        }
        //144239ms => 144s
        System.out.println("计算花费的时间为:" + (System.currentTimeMillis() - start) + "ms");
    }
}
