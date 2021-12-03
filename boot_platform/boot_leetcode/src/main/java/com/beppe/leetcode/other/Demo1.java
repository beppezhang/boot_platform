package com.beppe.leetcode.other;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo1 {

    @Test
    public void test1(){
        String abc = maxPalindrome("ababc");
        System.out.println("flag:"+abc);
    }

    public String maxPalindrome(String str){
        // 滑动窗口判断最长
        int max=0;
        int start=0;
        for (int  left= 0; left < str.length(); left++) {
            for (int right = left; right < str.length(); right++) {
                boolean isPalindrome = isPalindrome(str.substring(left, right + 1));
                if(isPalindrome){
                    int newMax=right-left+1;
                    if(newMax>max){
                        start=left;
                        max=newMax;
                    }
                }
            }
        }
        // 截取子串
        String aa = str.substring(start, start + max);
        return aa;
    }


    // 使用栈  判断是否为回文
    private boolean isPalindrome(String str){

        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(stack.pop());
        }
        if(str.equals(sb.toString())){
            return true;
        }
        return false;
    }

    private List<int[]> threeNum(int[] arr){
        List<int[]> list=new ArrayList<>();
        for (int left = 0; left < arr.length-2; left++) {
            for (int mid = left+1; mid < arr.length-1; mid++) {
                for (int last = mid+1; last < arr.length; last++) {
                    if(arr[left]+arr[mid]+arr[last]==0){
                        list.add(new int[]{arr[left],arr[mid]+arr[last]});
                    }
                }
            }
        }
        return list;

    }


}
