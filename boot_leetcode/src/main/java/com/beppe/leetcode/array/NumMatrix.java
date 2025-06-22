package com.beppe.leetcode.array;

/**
 * 二维数组
 */
public class NumMatrix {

    public int[][] preSum;
    // 构造二维数组前缀和
    public NumMatrix(int[][] matrix){
        // 二维数组  i j 之和
        int m = matrix.length;
        int n = matrix[0].length;
        preSum =new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int  j= 1; j <= n; j++) {
              preSum[i][j]=preSum[i][j-1]+preSum[i-1][j]+matrix[i-1][j-1]-preSum[i-1][j-1];
            }
        }
    }
}
