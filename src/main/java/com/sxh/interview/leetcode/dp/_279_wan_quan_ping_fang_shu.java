package com.sxh.interview.leetcode.dp;

import java.util.Arrays;

/**
 * @author sxh
 * @date 2022/3/30
 */
public class _279_wan_quan_ping_fang_shu {
    // 动态规划解法。时间复杂度：O(n√n)，空间复杂度O(n)
    public static int fun(int n) {
        /*
        转移方程：设dp[i]为和为i的完全平方数的最少数量
        首先找到了一个完全平方数j，那么接下来只要找到 i-j² 的最少平方数和即可。
        最终方程：dp[i] = min(dp[i - j²]) + 1
        */
        int[] dp = new int[n + 1];
        // 计算从 1 ~ n 的每个状态
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 状态转移方程，计算子序列
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
            printArr(dp);
        }
        return dp[n];
    }

    // 数学解法，利用4平方和定理
    public static int fun1(int n) {
        // 这个数本身就是完全平方数，答案为1
        if (isPerfectSquare(n)) {
            return 1;
        }
        // 这个数满足4平方和定理: n=4^k(8m+7)，答案为4
        if (is4Answer(n)) {
            return 4;
        }
        // 这个数满足 n = a² + b²，答案为2
        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i)) {
                return 2;
            }
        }
        // 否则，答案为3
        return 3;
    }
    // 判断是否是完全平方数
    private static boolean isPerfectSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }
    // 判断是否满足4平方和定理: n = 4^k*(8m+7)
    private static boolean is4Answer(int n) {
        while (n % 4 == 0) {
            n = n / 4;
        }
        return n % 8 == 7;
    }

    // 完全背包解法
    public static int fun2(int n) {
        // 设dp[j]表示最少使用多少个完全平方数凑出j
        // dp[j] = min(dp[j], dp[j - i * i] + 1)
        // dp[0] = 0;其他元素初始化为Max_value
        // 求组合个数，遍历顺序无要求，这里先遍历物品，再遍历背包
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
            printArr(dp);
        }
        return (dp[n] == Integer.MAX_VALUE) ? 0 : dp[n];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("动规解法：" + fun(12));
        System.out.println("数学解法：" + fun1(12));
        System.out.println("完全背包解法：" + fun2(12));
    }
}
