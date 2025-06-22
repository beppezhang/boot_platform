package com.beppe.leetcode.sort;

import org.testng.annotations.Test;

/**
 * 几种排序算法
 */
public class Demo1 {

    @Test
    public void test1(){
        int[] arr=new int[]{1,5,4,7,6,2,8,29,4,5,2,9};
        sort1(arr);
        System.out.println("arr:"+arr);
    }

    // 冒泡
    public void sort1(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }
}
