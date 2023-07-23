package com.beppe.leetcode.array;

import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void test1(){
        //
        int[][] num={{2,3,5,8},{4,5,8,6},{6,7,5,9}};
        // 构造二维数组前缀和
        NumMatrix matrix=new NumMatrix(num);
        int res = sumRegion(matrix, 1, 1, 3, 3);
        System.out.println("res:"+res);
    }

    private int sumRegion(NumMatrix matrix,int x1, int y1, int x2, int y2) {
        int[][] preSum = matrix.preSum;
        return preSum[x1][y1]-preSum[x1][y2]-preSum[x2][y1]+preSum[x2][y2];
    }
}


