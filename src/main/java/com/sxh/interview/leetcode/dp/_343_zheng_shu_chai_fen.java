package com.sxh.interview.leetcode.dp;

/**
 * 整数拆分
 * @author sxh
 * @date 2022/3/30
 */
public class _343_zheng_shu_chai_fen {
    // 动态规划1。时间复杂度: O(n²)，空间复杂度：O(n)
    public int integerBreak(int n) {
        // 转移方程：dp[i]表示将i拆分成至少两个正整数的和后，这些正整数的最大乘积。有两种情况：
        // 将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j * (i-j)；
        // 将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j * dp[i−j]
        // 最终方程：dp[i] = max(1≤j<i){max(j * dp[i - j], j * (i - j))}
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
