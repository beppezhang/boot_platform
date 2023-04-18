package com.beppe.leetcode.array;

import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void test1() {
        //  数组 n-> m 之和
        int[] arr = {3, 6, 9, 10, 4, 5, 7, 8};
        int i = nsum1(arr, 2, 4);
        System.out.println("结果：" + i);
    }

    private int sumNum(int[] arr, int n, int m) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= n && i <= m) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private int nsum1(int[] arr,int n,int m) {
        int[] newArr = new int[arr.length+1];
        getPreSum(arr,newArr);
        int res = newArr[m+1] - newArr[n];
        System.out.println("res:"+res);
        return res;
    }

    // 获取前缀之和
    private void getPreSum(int[] arr, int[] preArr) {
        preArr[0]=0;
        for (int i = 0; i < arr.length; i++) {
            preArr[i+1]=preArr[i]+arr[i];
        }
    }

    @Test
    public void test3(){
        int[][] preSum= {{1, 2,6,8}, {3,4,5,6}};
        System.out.println("preSum:"+preSum);
    }
}
