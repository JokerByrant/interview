package com.sxh.interview.leetcode.dp._complete_pack;

import java.util.Arrays;

/**
 * 完全背包-求组合数
 * @author sxh
 * @date 2022/4/7
 * @link {https://programmercarl.com/0518.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2II.html}
 */
public class _518_ling_qian_dui_huan {
    public static int fun2(int amount, int[] coins) {
        // 完全背包
        // 假设dp[j]表示使用硬币凑出的总金额j，可以有多少个硬币组合数。
        // dp[j] += dp[j - coins[i]]
        // dp[0] = 1，其他元素初始化为0
        // 本题求的是组合数，那么外层遍历物品，内层遍历背包
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
            printArr(dp);
        }
        return dp[amount];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1,2,5};
        System.out.println("一维数组：" + fun2(amount, coins));
    }
}
