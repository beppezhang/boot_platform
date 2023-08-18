package com.beppe.leetcode.array;

public class NumMatrix {

    private int[][] preSum;

    // matrix={{1,2,6,8}, {3,4,5,6},{7,4,3,5}}
    public NumMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("m:"+matrix[0][1]);
        preSum=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //  计算preSum   i，j  上的数据
                preSum[i][j]=preSum[i-1][j]+preSum[i][j-1]+matrix[i-1][j-1]-preSum[i-1][j-1];
            }
        }
    }

    public int[][] getPreSum() {
        return preSum;
    }

    public void setPreSum(int[][] preSum) {
        this.preSum = preSum;
    }
}
