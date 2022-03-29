package com.sxh.interview.leetcode.dp;

/**
 * 母牛生产(不死神牛)
 * @author sxh
 * @date 2022/3/29
 */
public class _mu_niu_sheng_chan {
    public static int fun(int n) {
        if (n < 5) {
            return n;
        }
        // 转移方程：dp[n] = dp[n - 1] + dp[n - 3]。解释：第n年牛的数量 = 前一年母牛数量 + 新出生的小牛数量(3年前的母牛数量)
        int cur = 4, pre1 = 3, pre2 = 2, tmp;
        for (int i = 5; i <= n; i++) {
            tmp = cur;
            cur = cur + pre2;
            pre2 = pre1;
            pre1 = tmp;
        }
        return cur;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("不死神牛第 %d 年数量：%d \n", i, fun(i));
        }
    }
}
