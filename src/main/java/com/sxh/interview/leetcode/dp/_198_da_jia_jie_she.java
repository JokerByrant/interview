package com.sxh.interview.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 强盗抢劫
 * @author sxh
 * @date 2022/3/28
 */
public class _198_da_jia_jie_she {
    // 传统递归，公式：f(n) = Max(f(n - 1), f(n - 2) + nums[n])
    public static int fun1(int[] nums) {
        return robTo1(nums.length - 1, nums);
    }
    // 求第index次的可偷窃到的最高金额
    public static int robTo1(int index, int[] nums) {
        // 确定边界 -> nums[0]和nums[1]
        if (index == 0) {
            return nums[0];
        }
        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robTo1(index - 1, nums), robTo1(index - 2, nums) + nums[index]);
    }

    // 带备忘录的递归
    private static final Map<Integer, Integer> map = new HashMap<>();
    public static int fun2(int[] nums) {
        return robTo2(nums.length - 1, nums);
    }
    // 求第index次的可偷窃到的最高金额
    public static int robTo2(int index, int[] nums) {
        // 确定边界 -> nums[0]和nums[1]
        if (index == 0) {
            return nums[0];
        }
        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (!map.containsKey(index)) {
            map.put(index, Math.max(robTo2(index - 2, nums) + nums[index], robTo2(index - 1, nums)));
        }
        return map.get(index);
    }

    // 动态规划
    public static int fun3(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            // 转移方程：f(n) = Max(f(n - 1), f(n - 2) + nums[n])
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[44];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.printf("递归解法：%d。耗时：%d \n", fun1(arr), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("带备忘录的递归：%d。耗时：%d \n", fun2(arr), System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.printf("动态规划：%d。耗时：%d \n", fun3(arr), System.currentTimeMillis() - start);
    }
}
