package com.sxh.interview.leetcode.dp._complete_pack;

import java.util.Arrays;

/**
 * 完全背包-求排列数
 * @author sxh
 * @date 2022/4/7
 * @link {https://programmercarl.com/0377.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C%E2%85%A3.html#_377-%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C-iv}
 */
public class _377_zu_he_zong_he_IV {
    public static int fun(int[] nums, int target) {
        // 完全背包-求排列数
        // 设dp[j]表示从nums中可以找到多少个元素组合，来填满容量为j的背包
        // dp[j] += dp[j - coins[i]]
        // dp[0] = 1;
        // 求排列数：外层遍历背包，内层遍历物品
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
            printArr(dp);
        }
        return dp[target];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println("一维数组：" + fun(nums, target));
    }
}
