package com.sxh.interview.leetcode.dp;

/**
 * @author sxh
 * @date 2022/3/29
 */
public class _303_shu_zu_qu_jian_he {
    static class NumArray {
        private int[] dp;

        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                // 转换方程：dp[n] = dp[n - 1] + nums[n]
                nums[i] = nums[i] + nums[i - 1];
            }
            this.dp = nums;
        }

        public int sumRange(int left, int right) {
            // 最终解：dp[right] - dp[left];
            if (right == 0) {
                return dp[0];
            } else if (left == 0) {
                return dp[right];
            }
            return dp[right] - dp[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        NumArray numArray = new NumArray(arr);
        System.out.println("动态规划解法：" + numArray.sumRange(10,20));
    }
}
