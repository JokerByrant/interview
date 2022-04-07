package com.sxh.interview.leetcode.dp._01_pack;

/**
 * 0-1背包
 * @author sxh
 * @date 2022/4/7
 */
public class _474_yi_he_ling {
    public int findMaxForm(String[] strs, int m, int n) {
        // 01背包: 本题中strs相当于物品，mn相当于背包重量，strs中每个子集中1的数量以及0的数量对应每件物品的重量
        // dp[i][j]表示由i个0和j个1组成的子集个数最多有多少
        // dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)。解释：zeroNum表示子元素中0的数量，oneNum表示1的数量
        // 01背包的dp初始化为0
        // 01背包外层遍历物品，内层遍历背包(倒序)。
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int oneNum = 0;
            int zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
