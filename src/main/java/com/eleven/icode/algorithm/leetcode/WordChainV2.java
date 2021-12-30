package com.eleven.icode.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/7/24
 */
public class WordChainV2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        //temp 用来保存当前的路径
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, wordList, temp, ans);
        return ans;
    }

    int min = Integer.MAX_VALUE;

    private void findLaddersHelper(String beginWord, String endWord, List<String> wordList,
                                   ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            if (min > temp.size()) {
                ans.clear();
                min = temp.size();
                ans.add(new ArrayList<>(temp));
            } else if (min == temp.size()) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        //当前的长度到达了 min，还是没有到达结束单词就提前结束
        if (temp.size() >= min) {
            return;
        }
        //遍历当前所有的单词
        for (int i = 0; i < wordList.size(); i++) {
            String curWord = wordList.get(i);
            //路径中已经含有当前单词，如果再把当前单词加到路径，那肯定会使得路径更长，所以跳过
            if (temp.contains(curWord)) {
                continue;
            }
            //符合只有一个单词不同，就进入递归
            if (oneChanged(beginWord, curWord)) {
                temp.add(curWord);
                findLaddersHelper(curWord, endWord, wordList, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean oneChanged(String beginWord, String curWord) {
        int count = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != curWord.charAt(i)) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return count == 1;
    }
}
