package com.eleven.icode.algorithm.bitmap;

/**
 * 注意在定义BitMap数组时，是使用最大的的那个数来确定数组长度
 * 可使用BitMap进行：
 * - 数据判重
 * - 对不重复数据排序
 * - 打标签问题
 * - 找不重复的数
 * - 统计数据
 * <p>
 * BitMap缺点：
 * - 数据不能重复：数据只能是0或1
 * - 数据量少时，相对普通HashMap没有优势
 * - 无法处理字符串：Hash冲突
 */
public class BitMap {
    byte[] bits;        // 若为byte那就一个只能存8个数
    int max;            // 表示最大的那个数

    public BitMap(int max) {
        this.max = max;
        bits = new byte[(max >> 3) + 1];        //max/8 + 1
    }

    public void add(int n) {    // 往bitmap里面添加数字
        if (n > max) {
            throw new IllegalArgumentException();
        }
        int bitsIndex = n >> 3; // 除以8就可知道byte数组下标
        int loc = n & 7;        // 用&运算，获取bit位
        bits[bitsIndex] |= 1 << loc; // 把bit数组中bisIndex下标的byte里面第loc个bit位置为1
    }

    public boolean find(int n) {
        if (n > max) {
            throw new IllegalArgumentException();
        }
        int bitsIndex = n >> 3; // 除以8就可知道byte数组下标
        int loc = n & 7;        // 这里其实还可以用&运算
        int flag = bits[bitsIndex] & 1 << loc; // 若原来那个位置是0 那肯定就是0 只有那个位置是1 才行
        return flag != 0;
    }

    public void delete(int n) {
        if (n > max) {
            throw new IllegalArgumentException();
        }
        int index = n >> 3;     // 除以8就可知道byte数组下标
        int loc = n & 7;        // 这里其实还可以用&运算
        bits[index] &= ~(1 << loc);
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(200000001); // 10亿
        bitMap.add(2);
        bitMap.add(3);
        bitMap.add(4);
        bitMap.add(63);
        bitMap.add(65);
        System.out.println(bitMap.find(3));
        System.out.println(bitMap.find(64));
        bitMap.delete(3);
        System.out.println(bitMap.find(3));
    }

}
