package com.beppe.leetcode.dynamic;

import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void test1(){
        int fib = fib(7);
        System.out.println("fib:"+fib);
    }

    private int fib(int n){
        if(n==1|| n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    private int fib1(int N){
        int[] memo=new int[N+1];
        return helper(memo,N);
    }
    private int helper(int[] memo,int n){
        if(n==0 || n==1){
            return n;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n]=helper(memo,n-1)+helper(memo,n-2);
        return memo[n];
    }

    @Test
    public void test2(){
        Integer i=1;
        Integer a=1;
        boolean equals = i.equals(a);
        System.out.println("equals:"+equals);
    }


}
