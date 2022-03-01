package com.eleven.icode.algorithm;

/**
 * @author by YingLong on 2022/3/1
 */
public class MaxNumber {

    public int getMaxNumber(int k) {
        String target = String.valueOf(k);
        int beforeIndex = 0;
        boolean flag = true;
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) < target.charAt(beforeIndex)) {
                flag = false;
                break; // 找出第一个前一位数字大于后一位数字的位置，并退出
            }
            beforeIndex++;
        }
        // 如果找到了分三种情况，需要向前借1位
        if (!flag) {
            int mid = Integer.parseInt(String.valueOf(target.charAt(beforeIndex))) - 1;
            String result = "";
            // 存在借位 则后续位都变为9
            for (int i = beforeIndex + 1; i < target.length(); i++) {
                result += "9";
            }
            // 情况一：向前借位导致前位变为0 且 是第一个位置时  直接返回
            if (mid == 0 && beforeIndex == 0) {
                return Integer.valueOf(result);
            } else if (mid > 0) { // 若借位后大于0则继续递归
                return getMaxNumber(Integer.parseInt(target.substring(0, beforeIndex) + mid + result));
            } else { // 若借位后小于0 需向前继续借位，且将当前位置为9
                for (; beforeIndex >= 0; beforeIndex--) {
                    mid = Integer.parseInt(String.valueOf(target.charAt(beforeIndex))) - 1;
                    if (mid < 0 && beforeIndex != 0) {
                        result += "9";
                    } else {
                        break;
                    }
                }
                return getMaxNumber(Integer.parseInt(target.substring(0, beforeIndex) + mid + result));
            }
        }
        // 如果没找到说明就是单调递增的  直接返回数字
        return k;
    }

    public static void main(String[] args) {
        MaxNumber number = new MaxNumber();
        System.out.println(number.getMaxNumber(10));
        System.out.println(number.getMaxNumber(1234));
        System.out.println(number.getMaxNumber(332));
        System.out.println(number.getMaxNumber(1000));
        System.out.println(number.getMaxNumber(1201));
    }

}
