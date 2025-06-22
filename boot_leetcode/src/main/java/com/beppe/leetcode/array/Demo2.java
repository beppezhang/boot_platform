package com.beppe.leetcode.array;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo2 {

    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，找出数组中和为目标值的两个数的索引。
     */
    @Test
    public void teet1(){
        int[] arr = {1,2,4,3,5};
        int target = 8;
        int[] index = getTwoSum(arr, target);
    }
    
        
    private int[] getIndex(int[] nums,int target){
        // 将nums 转为map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target-nums[i])!=null && map.get(target-nums[i])!=i){
                return new int[]{map.get(target-nums[i]),i};
            }
        }
        return null;
    }

    private int[] getTwoSum(int[] nums,int target){
        // 将nums 转为map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 找出需要的补数
            int num = target-nums[i];
            if(map.containsKey(num)){
                return new int[]{i,map.get(num)};
            }
            // 不包含加到map中
            map.put(nums[i],i);
        }
        return null;
    }
    @Test
    public void teet2(){
        int[] arr = {1,2,4,3,-3,4,-5};
        int i = sellStock(arr);
    }

    /**
     * 买卖股票的最佳时机 (Best Time to Buy and Sell Stock)
     * 给定一个数组 prices，其中 prices[i] 是第 i 天的股票价格。只允许完成一次交易，计算最大利润。
     * 返回天数
     */
    private int sellStock(int[] nums){
        int sum = 0;
        int day = 0;
        for (int i = 0; i < nums.length; i++) {
            // 之前总和加当天
            int total=sum+nums[i];
            if(total>sum){
                day = i;
            }
            sum = total;
        }
        return day;
    }

    /**
     * 将数组向右旋转 k 个位置。
     */
    private int[] rotateArr(int[] nums,int k){
        int length=nums.length;
        int t=k%5;
        if(t==0){
            return nums;
        }
        // 原数组切割成两个数组
        
    }
}
