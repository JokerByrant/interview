package com.sxh.interview.leetcode.dp._complete_pack;

import java.util.Arrays;

/**
 * 完全背包问题
 * @author sxh
 * @date 2022/4/6
 * @link {https://programmercarl.com/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85.html}
 */
public class _wan_quan_bei_bao {
    /**
     * 与01背包不同的是，完全背包的物品可以重复选择。
     * @param maxWeight 背包最大重量
     * @param num 物品数量
     * @param weights 物品的重量
     * @param values 物品的价值
     * @return
     */
    public static int fun(int maxWeight, int num, int[] weights, int[] values) {
        int[] dp = new int[maxWeight + 1];
        // 外层遍历背包
        for (int i = 1; i <= maxWeight; i++) {
            // 内层遍历物品
            for (int j = 0; j < num; j++) {
                if (i < weights[j]) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
            printArr(dp);
        }
        return dp[maxWeight];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int result = fun(4, 3, new int[]{1, 3, 4}, new int[]{15, 20, 30});
        System.out.println("完全背包(一维数组)：" + result);
    }
}
