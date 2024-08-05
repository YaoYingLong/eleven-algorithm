package com.eleven.icode.algorithm;

import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by Eleven on 2021/12/29
 */
public class SortTest {

    @Test
    public void insertSortTest001() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int i = 1; i < data.length; i++) {
            int target = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > target) {
                    break;
                }
                data[j + 1] = data[j];
            }
            data[j + 1] = target;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void shellSortTest001() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int step = data.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < data.length; i++) {
                int target = data[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (data[j] > target) {
                        break;
                    }
                    data[j + step] = data[j];
                }
                data[j + step] = target;
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void bulleSortTest001() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[i] < data[j]) {
                    data[i] = data[j] + data[i];
                    data[j] = data[i] - data[j];
                    data[i] = data[i] - data[j];
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void bulleSortTest002() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    data[j + 1] = data[j] + data[j + 1];
                    data[j] = data[j + 1] - data[j];
                    data[j + 1] = data[j + 1] - data[j];
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void quickSortTest002() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        heapSort(data);
        for (int datum : data) {
            System.out.println(datum);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            int target = -nums[first];
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[first]);
                    subList.add(nums[second]);
                    subList.add(nums[third]);
                    res.add(subList);
                }
            }
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int dl = left, dr = right, target = nums[left];
            while (dl < dr) {
                while (dl < dr && nums[dr] > target) {
                    dr--;
                }
                if (dl < dr) {
                    nums[dl++] = nums[dr];
                }
                while (dl < dr && nums[dl] < target) {
                    dl++;
                }
                if (dl < dr) {
                    nums[dr--] = nums[dl];
                }
                nums[dl] = target;
                quickSort(nums, left, dl - 1);
                quickSort(nums, dl + 1, right);
            }
        }
    }

    public void heapSort(int[] nums) {
        int len = nums.length;
        for (int start = (len >> 1) - 1; start >= 0; start--) {
            maxHeap(nums, start, len);
        }
        for (int end = len - 1; end > 0; end--) {
            int temp = nums[end];
            nums[end] = nums[0];
            nums[0] = temp;
            maxHeap(nums, 0, end);
        }
    }

    private void maxHeap(int[] nums, int start, int end) {
        int parent = start;
        int left = (parent << 1) + 1;
        while (left < end) {
            int max = left;
            if (left + 1 < end && nums[left + 1] > nums[max]) {
                max = left + 1;
            }
            if (nums[parent] >= nums[max]) {
                return;
            }
            int temp = nums[max];
            nums[max] = nums[parent];
            nums[parent] = temp;
            parent = max;
            left = (parent << 1) + 1;
        }
    }


    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for (int start = len / 2 - 1; start > -1; start--) {
            maxHeap(nums, start, len);
        }
        for (int i = len - 1; i > len - k; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeap(nums, 0, i);
        }
        return nums[0];
    }

    @Test
    public void test() {
        List<BigDecimal> nums = new ArrayList<>();
        nums.add(BigDecimal.valueOf(1.1));
        nums.add(BigDecimal.valueOf(2.1));
        nums.add(BigDecimal.valueOf(3.1));
        nums.add(BigDecimal.valueOf(4.1));
        BigDecimal summedReadings = nums.stream().reduce(BigDecimal.ZERO, (reading, accumulator) -> reading.add(accumulator));
        System.out.println(summedReadings.doubleValue());
        BigDecimal avgReadings = summedReadings.divide(BigDecimal.valueOf(nums.size()), RoundingMode.HALF_UP);
        System.out.println(avgReadings.doubleValue());
    }

    public static void main(String[] args) {
        // 随便虚拟一个日期
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期: " + now + " " + now.getDayOfWeek());
        // 求这个日期上一周的周一、周日
        LocalDateTime todayOfLastWeek = now.minusDays(7);
        LocalDateTime monday = todayOfLastWeek.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        LocalDateTime sunday = todayOfLastWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
        System.out.println("当前日期：" + now + " 上一周的周一：" + monday + " " + monday.getDayOfWeek());
        System.out.println("当前日期：" + now + " 上一周的周日：" + sunday + " " + sunday.getDayOfWeek());


        Instant mondayDateTime = now.toInstant(ZoneOffset.UTC);
        System.out.println("当前日期: " + mondayDateTime + " " + now.getDayOfWeek());
        mondayDateTime.atOffset(ZoneOffset.UTC).toLocalDate();
    }


    public String add(String param1, String param2) {
        int len1 = param1.length() - 1;
        int len2 = param2.length() - 1;

        int k = 0;
        String res = "";
        while (len1 > -1 || len2 > -1) {
            int a = deCode(len1 > -1 ? param1.charAt(len1--) : 0);
            int b = deCode(len2 > -1 ? param2.charAt(len2--) : 0);
            int temp = a + b + k;
            k = temp / 62;
            res = enCode(temp % 62) + res;
        }
        return k == 1 ? 1 + res : res;
    }

    private int deCode(int a) {
        if (a >= '0' && a <= '9') {
            a -= '0';
        } else if (a >= 'a' && a <= 'z') {
            a = a - 'a' + 10;
        }else if (a >= 'A' && a <= 'Z') {
            a = a - 'A' + 36;
        }
        return a;
    }

    private char enCode(int a) {
        if (a < 10) {
            return (char) (a + '0');
        } else if (a > 9 && a < 36) {
            return (char) (a - 10 + 'a');
        } else {
            return (char) (a - 36 + 'A');
        }

    }

    @Test
    public void test00001() {
        System.out.println(add("a", "1"));
        System.out.println(add("Z", "1"));
        System.out.println(add("19", "1"));
    }
}
