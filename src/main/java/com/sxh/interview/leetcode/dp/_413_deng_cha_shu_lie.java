package com.sxh.interview.leetcode.dp;

/**
 * @author sxh
 * @date 2022/3/29
 */
public class _413_deng_cha_shu_lie {
    // 动态规划
    public static int numberOfArithmeticSlices(int[] nums) {
        // dp[i]表示数组中第i个元素所在等差数列长度(dp[i] = 等差数列长度 - 3)。之后对dp按照斐波那契数列进行求和即可。
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

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,5,4,3,2}));
    }
}
