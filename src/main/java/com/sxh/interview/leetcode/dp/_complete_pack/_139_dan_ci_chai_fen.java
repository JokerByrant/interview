package com.sxh.interview.leetcode.dp._complete_pack;

import java.util.Arrays;
import java.util.List;

/**
 * 完全背包问题
 * @author sxh
 * @date 2022/4/6
 */
public class _139_dan_ci_chai_fen {
    public static boolean fun1(String s, List<String> wordDict) {
        // 解题思路: 完全背包问题

        // 确定dp数组及下标含义：dp[j]表示长度为j的字符串，是否可以由字典的元素填满。
        // 递归公式：if ([j,i]区间的字符出现在字典里 && dp[j] = true)，那么 dp[i] = true
        // 初始化：dp[0] = true。解释：长度为0的字符串，可以由字典的元素填满 -> 不填元素。
        // 遍历顺序：外层遍历背包，内层遍历物品。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
            printArr(dp);
        }
        return dp[s.length()];
    }

    private static void printArr(boolean[] dp) {
        for (boolean item : dp) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println("完全背包1：" + fun1(s, wordDict));
    }
}
