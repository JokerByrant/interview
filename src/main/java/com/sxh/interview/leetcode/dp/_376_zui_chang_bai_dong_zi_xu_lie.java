package com.sxh.interview.leetcode.dp;

import java.util.Arrays;

/**
 * 最长摆动子序列
 * @author sxh
 * @date 2022/3/31
 */
public class _376_zui_chang_bai_dong_zi_xu_lie {
    // 动态规划 O(n²) - O(n)
    public int wiggleMaxLength(int[] nums) {
        // 设dp[i]为以nums[i]结尾的数组最长摆动子序列长度。
        // 设0 <= j < i，若nums[i]可以加在nums[j]之后，那么长度+1
        // 转移方程：dp[i] = max{dp[i], dp[j] + 1}(0 <= j <i)
        // 边界条件: 若nums[i] == nums[i - 1], 则 dp[i] = dp[i - 1];
        // 若dp[i] == 1, 且nums[i] != nums[i - 1]，则dp[i] = 2;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1, cur, pre;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (dp[i] == 1) {
                dp[i] = 2;
            }
            for (int j = 1; j < i; j++) {
                cur = nums[i] - nums[j];
                pre = nums[j] - nums[j - 1];
                if ((cur > 0 && pre < 0) || (cur < 0 && pre > 0)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // 动态规划2 - 优化版
    public int wiggleMaxLength1(int[] nums) {
        // 设up[i]表示以前 i 个元素中的某一个为结尾的最长的「上升摆动序列」的长度
        // 设down[i]表示以前 i 个元素中的某一个为结尾的最长的「下降摆动序列」的长度
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }

    // 动态规划3 - 最终版
    public int wiggleMaxLength2(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 这里省略了上一步的比较大小操作，因为up和down的差值绝对值不会大于1(每一次谷到峰之前都会经历一次峰到谷，反之亦然)
                // 因此: up = max(up, down + 1) = down + 1; down = max(up + 1, down) = up + 1；
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    // 贪心算法
    public int wiggleMaxLength3(int[] nums) {
        // TODO
        return 0;
    }
}
