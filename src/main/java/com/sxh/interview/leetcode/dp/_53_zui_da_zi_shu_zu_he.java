package com.sxh.interview.leetcode.dp;

/**
 * 最大子数组和
 * @author sxh
 * @date 2022/3/29
 */
public class _53_zui_da_zi_shu_zu_he {
    public int maxSubArray(int[] nums) {
        // dp[n]表示以数组第n个元素为结尾的最大和连续子数组和
        // 转移方程：dp[n] = dp[n - 1] > 0 ? dp[n - 1] + num[n] : num[n];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
