package com.sxh.interview.leetcode.dp;

/**
 * 信件错排
 * @author sxh
 * @date 2022/3/29
 */
public class _634_xin_jian_cuo_pai {
    public static int fun(int n) {
        if (n < 2) {
            return 0;
        }
        // 转移方程：dp[n] = (n - 1) * (dp[n - 1] + dp[n - 2])
        int pre = 0, cur = 1, tmp;
        // 从3个元素的情况开始循环，cur为dp[2]=1，pre为dp[1]=0
        for (int i = 3; i <= n; i++) {
            tmp = cur;
            cur = (i - 1) * (cur + pre);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.printf("动态规划解法：%d", fun(4));
    }
}
