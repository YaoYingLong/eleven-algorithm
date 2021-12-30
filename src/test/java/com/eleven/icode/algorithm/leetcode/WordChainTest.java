package com.eleven.icode.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by YingLong on 2020/7/24
 */
public class WordChainTest {

    @Test
    public void findLaddersTest() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        {
            WordChainV1 chain = new WordChainV1();
            List<List<String>> resultList = chain.findLadders(beginWord, endWord, wordList);
            System.out.println("V1: " + resultList);
        }
        {
            WordChainV2 chain = new WordChainV2();
            List<List<String>> resultList = chain.findLadders(beginWord, endWord, wordList);
            System.out.println("V2: " + resultList);
        }
    }
}
