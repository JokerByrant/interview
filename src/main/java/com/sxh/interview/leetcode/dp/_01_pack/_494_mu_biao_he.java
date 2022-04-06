package com.sxh.interview.leetcode.dp._01_pack;

import java.util.Arrays;

/**
 * 0-1背包组合排列问题 --- 求组合数
 * 递推公式：dp[j] += dp[j - nums[i]]
 * @author sxh
 * @date 2022/4/6
 */
public class _494_mu_biao_he {
    // 动规解法1：一维数组0-1背包
    public static int fun1(int[] nums, int target) {
        // 解题思路：转换一下思路，最终解可以定义为 -> target = sum(+) + sum(-)，其中sum(+)表示符号为+的元素的和，sum(-)表示符号为-的元素的和。
        //          又因为 sum(nums) = sum(+) - sum(-)，因此 sum(+) = (sum(nums) + target) / 2
        //          所以，最终问题可以转化为：是否可以从给定数组中找出一批数，这些数的和等于 (sum(nums) + target) / 2。
        //          这道题是背包中的排列组合问题，之前的一道 #416 是求和，两道题不一样。

        // 动规解题五步法：
        // 1.确定dp数组以及下标的含义：设dp[j]表示容量为j的背包，最大可以凑出的物品组合有多少种
        // 2.确定转移方程：dp[j] += dp[j - nums[i]]。解释：dp[3]表示容量为3的背包最大可以凑出的物品组合，dp[3] = dp[2] + dp[1] + dp[0]
        // 3.初始化: dp[0] = 1，其他元素为0。解释dp[0] = 1：装满容量为0的背包，有一种方法，也就是装0件物品。
        // 4.遍历顺序：数组元素放外层循环，背包重量在内存循环。使用的是一维数组，因此内存循环倒序遍历。
        // 5.举例推导
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        int maxWeight = Math.abs((sum + target) / 2);
        int[] dp = new int[maxWeight + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = maxWeight; j >= num; j--) {
                dp[j] += dp[j - num];
            }
            printArr(dp);
        }
        return dp[maxWeight];
    }

    // 动规解法2：二维数组0-1背包
    public static int fun2(int[] nums, int target) {
        // 1.确定dp数组以及下标的含义：设dp[i][j]表示从下标 [0,i] 的元素中任取，装入容量为j的背包，可以装入的物品组合有几种
        // 2.确定转移方程：dp[i][j] += dp[i - 1][j - nums[i]]。
        // 3.初始化: dp[0][0] = 1, 其他元素初始化为0
        // 4.遍历顺序：外层遍历数组元素，内层遍历背包重量。
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        int maxWeight = Math.abs((sum + target) / 2);
        int[][] dp = new int[nums.length + 1][maxWeight + 1];
        // 背包重量为0，可以装入的物品组合有1种 -> 装0件物品
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        // 特殊情况：当nums[i]=0 && 背包容量=0时，有两种选择，放0件物品、放1件物品，因此此时 dp[i][0] = 2
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][maxWeight];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr= new int[]{0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println("一维数组动规：" + fun1(arr, target));
        System.out.println("二维数组动规：" + fun2(arr, target));
    }
}
