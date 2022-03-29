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
        System.out.printf("动态规划解法：%d", fun(2));
    }

    /*
        状态定义
            设动态规划列表 dp，dp[i] 表示前 i 个信和信封的错误方式数量。

        转移方程
            第 i 个信装到了第 j 个信封中，第 j 个信装到了第 k 个信封中。
            若 i == k，交换 i 和 j 后，还有n - 2 封信发生了错排，并且因为 j 的位置有 n - 1 种取值(除 j 之外的位置)，因此这种情况的方程为 ：dp[n] = (n - 1) * dp[n - 2]。
            若 i != k，交换 i 和 j 后，还有 n - 1 封信发生了错排，j 的位置有 n - 1 中取值，dp[n] = (n - 1) * dp[n - 1]
            最终的方程：dp[n] = (n - 1) * (dp[n - 1] + dp[n - 2])

        初始状态
            dp[1] = 0、dp[2] = 1

        返回值
            返回 dp 列表的最后一个值

        简化空间复杂度
            dp[n] 只与 dp[n - 1] 和 dp[n - 2] 有关
     */
}
