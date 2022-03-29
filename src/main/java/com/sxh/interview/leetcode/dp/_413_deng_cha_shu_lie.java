package com.sxh.interview.leetcode.dp;

/**
 * @author sxh
 * @date 2022/3/29
 */
public class _413_deng_cha_shu_lie {
    public int numberOfArithmeticSlices(int[] nums) {
        // dp[i]表示数组中第i个元素，是等差子数组(从第3个元素开始)的第几个元素，之后对dp数组按斐波那契数列求和即为结果
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i -1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
    }
}
