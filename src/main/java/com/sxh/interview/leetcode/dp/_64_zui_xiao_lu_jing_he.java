package com.sxh.interview.leetcode.dp;

import java.util.Random;

/**
 * 最小路径和
 * @author sxh
 * @date 2022/3/29
 */
public class _64_zui_xiao_lu_jing_he {
    public static int fun(int[][] grid) {
        System.out.println("变更后的数组元素：");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        System.out.println("数组元素：");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = new Random().nextInt(10);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.printf("最小路径和为：%d", fun(arr));
    }
    /*
         解题思路：先将数组中每个位置的最小路径都求出来，然后取dp[i][j]位置的即可
         转换方程：dp[i][j]表示走到(i,j)的最小路径和，分以下几个情况：
         i=0,j=0时：dp[i][j]=grid[i][j]
         i=0,j!=0时，dp[i][j]=dp[i][j-1] + grid[i][j]
         i!=0,j=0时，dp[i][j]=dp[i-1][j] + grid[i][j]
         i!=0,j!=0时，dp[i][j]=min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
   */
}
