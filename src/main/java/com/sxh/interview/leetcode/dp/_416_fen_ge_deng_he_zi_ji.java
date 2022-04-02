package com.sxh.interview.leetcode.dp;

import java.util.Arrays;

/**
 * 0—1背包问题：分割等和子集
 * @author sxh
 * @date 2022/4/2
 */
public class _416_fen_ge_deng_he_zi_ji {
    // 动态规划(二维数组)
    public static boolean canPartition(int[] nums) {
        // 解题思路：此题是 0-1 背包问题，转换一下问题：是否可以从给定数组中找出一批正整数，这些数的和等于数组总和的一半。
        //      可以将题中的关键元素转换为背包问题需要的元素：背包最大重量、每个物品的重量、每个物品的价值。
        //      maxWeight=sum/2(数组元素和的一半)、每个物品的重量 = 每个物品的价值 = 数组元素的值

        // 动规解题五步法：
        // 1.确定dp数组及其含义：设dp[i][j]表示从 [0,i] 下标的元素中任取，放入容量为j的背包，最大可以凑出的子集总和是多少。
        // 2.确定递推公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i])
        // 3.初始化：所有元素初始化为0；
        // 4.遍历顺序：外层遍历物品信息，内层遍历背包重量。
        // 5.举例推导dp数组。
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int maxWeight = sum / 2;
        int[][] dp = new int[nums.length][maxWeight + 1];
        // 注意遍历的边界问题，这里nums最大下标为nums.length - 1，所以遍历nums要小于nums.length。
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[nums.length - 1][maxWeight] == maxWeight;
    }


    // 动态规划(一维数组)
    public static boolean canPartition1(int[] nums) {
        // 解题思路：此题是 0-1 背包问题，转换一下问题：是否可以从给定数组中找出一批正整数，这些数的和等于数组总和的一半。
        //      可以将题中的关键元素转换为背包问题需要的元素：背包最大重量、每个物品的重量、每个物品的价值。
        //      maxWeight=sum/2(数组元素和的一半)、每个物品的重量 = 每个物品的价值 = 数组元素的值

        // 动规解题五步法：
        // 1.确定dp数组及其含义：设dp[j]表示容量为j的背包，最大可以凑出的子集总和是多少。
        // 2.确定递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i])
        // 3.初始化：所有元素初始化为0；
        // 4.遍历顺序：外层遍历物品信息，内层遍历背包重量，且内层倒序遍历。
        // 5.举例推导dp数组。
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int maxWeight = sum / 2;
        int[] dp = new int[maxWeight + 1];
        for (int num : nums) {
            for (int j = maxWeight; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
            printArr(dp);
        }
        return dp[maxWeight] == maxWeight;
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        boolean result = canPartition(nums);
        System.out.println("动态规划(二维数组)：" + result);
        result = canPartition1(nums);
        System.out.println("动态规划(一维数组)：" + result);
    }
}
