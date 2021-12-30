package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.tree.PreorderTraversal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author by YingLong on 2020/8/18
 */
public class PreorderTraversalTest {

    @Test
    public void recoverFromPreorderTest() {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        String S = "1-2--3--4-5--6--7";
        preorderTraversal.recoverFromPreorder(S);
    }

    public List<String> getSubS(String S, String D) {
        List<String> resultList = new ArrayList<>();
        String wordToFind = "[0-9]" + D + "[0-9]";
        Pattern word = Pattern.compile(wordToFind);
        Matcher match = word.matcher(S);
        int firstStart = 0;
        int firstEnd = 0;
        int lastStart = 0;
        int k = 0;
        while (match.find()) {
            if (k == 0) {
                firstStart = match.end() - 2;
            } else {
                firstEnd = match.start() + 1;
                lastStart = match.end() - 2;
            }
            k++;
        }
        if (k > 1) {
            resultList.add(S.substring(firstStart, firstEnd));
            resultList.add(S.substring(lastStart));
        } else {
            resultList.add(S.substring(firstStart));
        }
        return resultList;
    }
}
