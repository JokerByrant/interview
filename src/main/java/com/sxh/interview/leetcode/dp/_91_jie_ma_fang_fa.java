package com.sxh.interview.leetcode.dp;

/**
 * @author sxh
 * @date 2022/3/30
 */
public class _91_jie_ma_fang_fa {
    public static int numDecodings(String s) {
        // 转移方程：设dp[i]为长度为i的字符包含的解码方法总数
        // 若最后两个数字组合大于26，那么 dp[i] = dp[i - 1]
        // 若最后两个数字组合小于等于26，那么 dp[i] = dp[i - 1] + 1
        int n = s.length();
        int pre = 0, cur = 1, tmp = 0;
        for (int i = 1; i <= n; ++i) {
            tmp = 0;
            if (s.charAt(i - 1) != '0') {
                tmp += cur;
            }
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                tmp += pre;
            }
            pre = cur;
            cur = tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("22262124"));
    }
}
