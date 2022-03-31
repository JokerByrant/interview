package com.sxh.interview.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一组整数对能够构成的最长链
 * @author sxh
 * @date 2022/3/31
 */
public class _646_Maximun_Length_Of_Pair_Chain {
    // 动态规划: O(n²)
    public int findLongestChain(int[][] pairs) {
        // 转换方程：设dp[i]为i个数对可以形成的最长数对链长度
        // 假设0 <= j < i, 若d[i][0] > dp[j][1]，那么最长数对链长度 +1
        // 最终方程：dp[i] = max{dp[i], dp[j] + 1}(0 <= j < i)

        // 题中提到可以以任何顺序选择，因此先对原数据进行升序排序
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[pairs.length];
        // 默认长度1
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // 贪心算法 O(nlogN)
    public int findLongestChain2(int[][] pairs) {
        // 思路：将数对根据第二个数进行升序排列，之后遍历数组，若nums[i][1] < nums[j][0]，i < j，则结果 +1
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int result = 0, pre = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pre < pair[0]) {
                pre = pair[1];
                result++;
            }
        }
        return result;
    }
}
