package com.sxh.interview.leetcode.dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 * @author sxh
 * @date 2022/3/30
 */
public class _300_zui_chang_di_zeng_zi_xu_lie {
    public int lengthOfLIS(int[] nums) {
        // 转换方程：设dp[i]为以nums[i]结尾的最长严格递增子序列的长度
        // 假设 0 < j < i，若nums[i]可以接在nums[j]之后，最长序列长度+1
        int[] dp = new int[nums.length];
        int result = 0;
        // 长度默认1
        Arrays.fill(dp, 1);
        // 依次遍历每个元素
        for (int i = 0; i < nums.length; i++) {
            // 判断nums[i]是否大于之前子序列中元素(子序列下标[0, i))
            // 若大于则表示nums[i]可以加到之前的子序列之后，则长度+1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 取最长的子序列长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
