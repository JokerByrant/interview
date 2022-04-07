package com.sxh.interview.leetcode.dp._complete_pack;

import java.util.Arrays;

/**
 * 完全背包-求最小组合数
 * @author sxh
 * @date 2022/4/7
 * @link {https://programmercarl.com/0322.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2.html#%E6%80%9D%E8%B7%AF}
 */
public class _322_ling_qian_dui_huan {
    public static int fun(int[] coins, int amount) {
        // 完全背包-求组合
        // 设dp[j]表示从coins选出硬币凑出总金额j的最少硬币个数
        // dp[j] = min(dp[j], dp[j - coins[i]] + 1)
        // dp[0] = 0;由于dp[j]要取的是最小值，因此其他元素的值置为Integer.MAX_VALUE。
        // 求组合：外层遍历物品，内层遍历背包
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                // 只有dp[j - coin]不是初始化的最大值时，才有比较的必要
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {3};
        int target = 2;
        System.out.println("一维数组：" + fun(nums, target));
    }
}
