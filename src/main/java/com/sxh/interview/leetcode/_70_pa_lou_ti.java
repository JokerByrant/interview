package com.sxh.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 * 解题思路：1.找表达式 2.定边界 3.确定起始位置(开始or末尾)
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
     * 利用数组(从开头开始)
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

    private static Map<Integer, Integer> map = new HashMap<>();
    /**
     * 带备忘录的递归
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        if (!map.containsKey(n)) {
            map.put(n, climbStairs3(n - 1) + climbStairs3(n - 2));
        }
        return map.get(n);
    }

    /**
     * 最终解(动态规划求解)
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
        System.out.printf("递归解法: %d。用时：%d \n", climbStairs1(40), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("数组解法: %d。用时：%d \n", climbStairs2(40), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("备忘录解法: %d。用时：%d \n", climbStairs3(40), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("最终解: %d。用时：%d \n", climbStairs(40), System.currentTimeMillis() - start);
    }
}
