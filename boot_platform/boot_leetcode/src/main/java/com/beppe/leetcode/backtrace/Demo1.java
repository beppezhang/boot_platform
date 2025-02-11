package com.beppe.leetcode.backtrace;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> track=new LinkedList<>();

    @Test
    public void test1(){
        int[] arr=new int[]{1,2,3};
        List<List<Integer>> allSorts = getAllSorts(arr);
        System.out.println("allSorts:"+allSorts);
    }

    private List<List<Integer>> getAllSorts(int[] nums){
        // 存放路径
        // 调用回溯方法
        backTrace(nums);
        return res;
    }

    private void backTrace(int[] nums){
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
            backTrace(nums);
            // 撤销选择
            track.removeLast();
        }
    }

    // start 控制遍历的起始位置
    private void backTrace11(int[] nums,LinkedList<Integer> track){
        // 如果track 长度就是nums  长度则为一个排列结果
        if(nums.length==track.size()){
            res.add(new ArrayList<>(track));
            return;
        }
        // 遍历数组 (遍历可以做选择的列表)
        for (int i = 0; i < nums.length; i++) {
            // 做选择
            if(track.contains(nums[i])){
                // 结束
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一个决策
            backTrace11(nums,track);
            // 昨晚所有决策后，撤销选择
            track.removeLast();
        }

    }

    @Test
    public void test2(){
//        int[] arr=new int[]{1,2,3};
//        backTrace33(arr,0);
        System.out.println("取模="+200%1);
    }

    // 求出数组的子集   start  遍历起始位置
    private void backTrace33(int[] nums,int start){
        // 每个节点都是一个子集
        res.add(new ArrayList<>(track));
        // 遍历多叉树 遍历可以选择的列表
        for (int i = start; i < nums.length; i++) {
            // 做出选择
            track.add(nums[i]);
            // 进入下一个决策  下一个决策树从  start+1  位置开始
            backTrace33(nums,i+1);
            track.removeLast();
        }
    }

}
