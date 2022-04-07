package com.sxh.interview.leetcode.dp;

import java.util.Arrays;

/**
 * 强盗在环形截取抢劫
 * @author sxh
 * @date 2022/3/28
 * @link {https://leetcode-cn.com/problems/house-robber-ii/solution/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/}
 */
public class _213_da_jia_jie_she_2 {
    /*
        状态定义
            设动态规划列表 dp，dp[i] 表示第 i 间房能偷窃的最高金额。

        转移方程
            不抢第 n 间房子，前 n 间房子的最高金额 dp[n] = dp[n - 1]；
            抢第 n 间房子，前 n 间房子最高金额为 dp[n] = dp[n - 2] + num[n]。
            最终的方程：dp[n] = max(dp[n - 1], dp[n - 2] + num[n])

        初始状态
            dp[0] = 0

        返回值
            返回 dp 列表的最后一个值

        简化空间复杂度
            dp[n] 只与 dp[n - 1] 和 dp[n - 2] 有关
     */

    // 动态规划
    public static int fun(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robAction(Arrays.copyOfRange(nums, 0, nums.length - 1)), robAction(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private static int robAction(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    // 动态规划-优化版, 表达式：dp[n] = max(dp[n - 1], dp[n - 2] + num[n])
    public static int fun1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robAction1(Arrays.copyOf(nums, nums.length - 1)), robAction1(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private static int robAction1(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            // 转移方程: dp[n] = max(dp[n - 1], dp[n - 2] + num[n])
            cur = Math.max(cur, pre + num);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        System.out.println("动态规划：" + fun(nums));
        System.out.println("动态规划-优化版：" + fun1(nums));
    }
}
