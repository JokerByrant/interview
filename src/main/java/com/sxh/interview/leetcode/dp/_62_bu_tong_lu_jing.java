package com.sxh.interview.leetcode.dp;

import java.util.Arrays;

/**
 * 不同路径
 * @author sxh
 * @date 2022/3/29
 */
public class _62_bu_tong_lu_jing {
    // 动态规划
    public static int fun(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }
    // 动态规划优化版
    public static int fun1(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        return arr[n - 1];
    }
    public static void main(String[] args) {
        int m = 3, n = 10;
        System.out.println("动态规划：" + fun(m, n));
        System.out.println("动态规划优化版：" + fun1(m, n));
    }
    /*
        dp[i][j]为走到第(i,j)位置的方法数，转换方程分几种情况：
        i=0,j=0: dp[i][j] = 1
        i!=0,j=0: dp[i][j] = 1
        i=0,j!=0: dp[i][j] = 1
        i!=0,j!=0: dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
}
