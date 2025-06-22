package com.beppe.leetcode.window;

import org.testng.annotations.Test;

public class Demo2 {

    @Test
    public void test1(){

    }

    // 删除升序数组的重复元素
    private void removeDuplicates(int[] nums){
        for (int left = 0; left < nums.length; left++) {
            for (int right = left+1; right < nums.length; right++) {
                // 左右元素比较  不相等  right后移
                if(nums[left]!=nums[right]){

                }
            }
        }
    }
}
