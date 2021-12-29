package com.eleven.icode.algorithm;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * @author by Eleven on 2021/12/29
 */
public class GenerateAgeTest {
    public static void main(String[] args) throws Exception {
        final String fileName = "E:\\IData\\test\\age1.txt";
        final Random random = new Random();
        BufferedWriter objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (int i = 0; i < 1400000000; i++) {
            int age = Math.abs(random.nextInt()) % 180;
            objWriter.write(age + "\r\n");
        }
        objWriter.flush();
        objWriter.close();
    }
}
