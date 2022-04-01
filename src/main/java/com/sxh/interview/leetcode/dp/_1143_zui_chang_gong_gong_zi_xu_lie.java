package com.sxh.interview.leetcode.dp;

/**
 * 最长公共子序列
 * @author sxh
 * @date 2022/4/1
 * @link {https://leetcode-cn.com/problems/longest-common-subsequence/solution/fu-xue-ming-zhu-er-wei-dong-tai-gui-hua-r5ez6/}
 */
public class _1143_zui_chang_gong_gong_zi_xu_lie {
    // 动态规划 O(mn)、O(mn)
    public int longestCommonSubsequence(String text1, String text2) {
        // 动态规划：假设dp[i][j]为text1的[0, i-1]字符和text2的[0, j-1]个字符的最长公共子序列长度
        // 当text1的第i个字符与text2的第j个字符相等，那么最大长度+1：dp[i][j] = dp[i-1][j-1] + 1
        // 当text1的第i个字符与text2的第j个字符不相等时，那么dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
