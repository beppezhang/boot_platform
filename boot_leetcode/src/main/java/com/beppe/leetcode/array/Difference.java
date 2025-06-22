package com.beppe.leetcode.array;

public class Difference {

    private int[] diff;

    public Difference(int[] arr) {
        // 构建差分数组
        diff=new int[arr.length];
        diff[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i]=arr[i]-arr[i-1];
        }

    }

    // 差分数组还原数组
    public int[] getArr(){
        int[] res=new int[diff.length];
        res[0]=diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i]=res[i-1]+diff[i];
        }
        return res;
    }

    // 给区间 i--j  加上 k
    public void addK(int i,int j,int k){
        diff[i]+=k;
        if(j+1<diff.length){
            diff[j+1]-=k;
        }

    }


    public int[] getDiff() {
        return diff;
    }

    public void setDiff(int[] diff) {
        this.diff = diff;
    }


}
