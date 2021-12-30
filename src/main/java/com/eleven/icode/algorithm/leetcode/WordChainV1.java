package com.eleven.icode.algorithm.leetcode;

import java.util.*;

/**
 * @author by YingLong on 2020/7/24
 */
public class WordChainV1 {

    private static final int INF = 1 << 20;
    public Map<String, Integer> wordIdMap;
    public ArrayList<String> idWordList;
    public ArrayList<Integer>[] edges;

    public WordChainV1() {
        wordIdMap = new HashMap<>();
        idWordList = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        for (String word : wordList) {
            if (!wordIdMap.containsKey(word)) {
                wordIdMap.put(word, id++);
                idWordList.add(word);
            }
        }
        if (!wordIdMap.containsKey(endWord)) {
            return new ArrayList<>();
        }

        if (!wordIdMap.containsKey(beginWord)) {
            idWordList.add(beginWord);
            wordIdMap.put(beginWord, id++);
        }

        edges = new ArrayList[idWordList.size()];
        for (int i = 0; i < idWordList.size(); i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < idWordList.size(); i++) {
            for (int j = i + 1; j < idWordList.size(); j++) {
                if (transformCheck(idWordList.get(i), idWordList.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordIdMap.get(endWord);
        List<List<String>> resultList = new ArrayList<>();
        int[] cost = new int[id];
        for (int i = 0; i < id; i++) {
            cost[i] = INF;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordIdMap.get(beginWord));
        queue.add(tmpBegin);
        cost[wordIdMap.get(beginWord)] = 0;

        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int last = now.get(now.size() - 1);
            if (last == dest) {
                List<String> subResultList = new ArrayList<>();
                for (Integer integer : now) {
                    subResultList.add(idWordList.get(integer));
                }
                resultList.add(subResultList);
            } else {
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        List<Integer> tmpList = new ArrayList<>(now);
                        tmpList.add(to);
                        queue.add(tmpList);
                    }
                }
            }
        }
        return resultList;
    }

    public boolean transformCheck(String paramA, String paramB) {
        int differences = 0;
        for (int i = 0; i < paramA.length() && differences < 2; i++) {
            if (paramA.charAt(i) != paramB.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }
}
