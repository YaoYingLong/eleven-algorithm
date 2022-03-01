package com.eleven.icode.algorithm.classic;

import java.util.Arrays;

/**
 * @author by YingLong on 2022/2/26
 */
public class PrimeNumber {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        // i若能被x整除，则x/i肯定能被x整除，因此只需判断i和根号x之中较小的即可
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n]; // false表示是一个素数，true表示合数
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                ans += 1;
                // 将合数标记为true，j = i * i 从 2 * i 优化而来，系数2会随着遍历递增（j += i，相当于递增了系数2），
                // 每一个合数都会有两个比本身要小的因子(0,1除外)，2 * i必然会遍历到这两个因子，当2递增到大于根号n时，
                // 其实后面的已经无需再判断（或者只需判断后面一段），而2到根号n、实际上在 i 递增的过程中已经计算过了，i实际上就相当于根
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return ans;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int pivotIndex(int[] nums) {
        int sum1 = Arrays.stream(nums).sum();
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
            if (sum1 == sum2) {
                return i;
            }
            sum1 = sum1 - nums[i];
        }
        return -1;
    }
}
