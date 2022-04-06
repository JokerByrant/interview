package com.sxh.interview.leetcode.dp._01_pack;

import java.util.Arrays;

/**
 * 0-1背包问题
 * @author sxh
 * @date 2022/4/1
 * @link {https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html#%E4%BA%8C%E7%BB%B4dp%E6%95%B0%E7%BB%8401%E8%83%8C%E5%8C%85}
 */
public class _0_1_bei_bao {
    /**
     * 0-1背包问题(动规解法)
     * 解题步骤如下：
     *         1.确定dp数组及下标的含义: 设dp[i][j]表示从[0, i]下标的物品中任取，放入容量为j的背包中，最大价值是多少。
     *         2.确定递推公式，考虑两种情况，第i个物品是否要放入背包。不放：dp[i][j] = dp[i - 1][j]；放：dp[i][j] = dp[i - 1][j - weights[i]] + values[i]。
     *           最终公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i])
     *         3.初始化dp: 如果背包的容量j为0，那么表示无法放入物品，即dp[i][0] = 0。在
     *           递推公式中，i是由i-1推导来的，那么dp[0][j]也是进行初始化，考虑两种情况：
     *           j < weights[i] 时：背包放不下物品，dp[0][j] = 0
     *           j >= weights[i] 时：dp[0][j] = values[i];
     *         4.确定遍历顺序。有两种遍历顺序：先遍历背包重量 or 先遍历物品。由递归公式可知，dp需要的数据来源于左上角，而两个循环都是起始于左上角，那么两种循环皆可。
     *         5.举例推导dp数组。这一部可以在测试时进行。
     * @param maxWeight 背包最大重量
     * @param num 物品数量
     * @param weights 物品的重量
     * @param values 物品的价值
     */
    public static int fun(int maxWeight, int num, int[] weights, int[] values) {
        int[][] dp = new int[num + 1][maxWeight + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i - 1] > j) {
                    // 第i个物品的重量超过了背包重量，放不进去
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 第i个物品可以放进背包(可以选择放或不放)
                    dp[i][j] = Math.max(dp[i -1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[num][maxWeight];
    }

    /**
     * 0-1背包问题(动规解法2-滚动数组)
     * 将上面的解法通过滚动数组进行优化，仍然按照动规5步法进行解题：
     *          1.确定dp数组及下标含义：设dp[j]表示容量为j的背包，所背的物品价值最大为dp[j]
     *          2.递推公式：dp[j] = max(dp[j], dp[j - weights[i]] + values[i])
     *          3.初始化：背包重量为0时，所背物品最大价值dp[0]=0。j>0时，也将dp[j]初始化为0即可。
     *          4.遍历顺序：倒序遍历，为了保证物品不被重复放入背包，代码如下：
     *              for(int i = 0; i < len; i++) {
     *                  for(int j = maxWeight; j >= weights[i]; j--) {
     *                       dp[j] = max(dp[j], dp[j - weights[i]] + values[i]);
     *                  }
     *              }
     *          5.举例推导dp数组。
     * @param maxWeight 背包最大重量
     * @param num 物品数量
     * @param weights 物品的重量
     * @param values 物品的价值
     * @return
     */
    public static int fun2(int maxWeight, int num, int[] weights, int[] values) {
        int[] dp = new int[maxWeight + 1];
        for (int i = 0; i < num; i++) {
            for (int j = maxWeight; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
            printArr(dp);
        }
        return dp[maxWeight];
    }

    private static void printArr(int[] dp) {
        Arrays.stream(dp).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int result = fun(4, 3, new int[]{1, 3, 4}, new int[]{15, 20, 30});
        System.out.println("动态规划(常规解法-二维数组)：" + result);
        result = fun2(4, 3, new int[]{1, 3, 4}, new int[]{15, 20, 30});
        System.out.println("动态规划(一维数组)：" + result);
    }
}
