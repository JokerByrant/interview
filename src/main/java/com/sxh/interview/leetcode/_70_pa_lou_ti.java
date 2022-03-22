package com.sxh.interview.leetcode;

/**
 * 斐波那契数列-使用动态规划算法求解
 * 解体思路：1.找表达式 2.定边界 3.确定起始位置(开始or末尾)
 * @author sxh
 * @date 2022/3/22
 */
public class _70_pa_lou_ti {
    /**
     * 利用递归求解(从末尾开始)
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 进一步优化，利用数组(从开头开始)
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    /**
     * 最终解
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.printf("递归解法: %d。用时：%d \n", climbStairs1(45), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("数组解法: %d。用时：%d \n", climbStairs1(45), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("最终解: %d。用时：%d \n", climbStairs1(45), System.currentTimeMillis() - start);
    }
}
