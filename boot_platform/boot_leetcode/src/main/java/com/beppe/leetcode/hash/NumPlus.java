package com.beppe.leetcode.hash;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 */
public class NumPlus {

    @Test
    public void test1() {
        int[] nums=new int[]{2,9,5,11,5,8};
        int target=10;
        int[] index = getIndex(nums, target);

    }

    public int[] getIndex(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length ; i++) {
            // 这个元素是否在前面的列表中
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
