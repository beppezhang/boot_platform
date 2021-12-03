package com.beppe.leetcode.backtrace;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {

    List<List<Integer>> res=new ArrayList<>();

    @Test
    public void test1(){
        int[] arr=new int[]{1,2,3};
        List<List<Integer>> allSorts = getAllSorts(arr);
        System.out.println("allSorts:"+allSorts);
    }

    private List<List<Integer>> getAllSorts(int[] nums){
        // 存放路径
        LinkedList<Integer> track=new LinkedList<>();
        // 调用回溯方法
        backTrace(nums,track);
        return res;
    }

    private void backTrace(int[] nums,LinkedList<Integer> track){
        // 结束条件
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        // 穷举
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            // 做选择  将元素添加到路径中
            track.add(nums[i]);
            // 进入下一个决策
            backTrace(nums,track);
            // 撤销选择
            track.removeLast();
        }
    }

}
