package com.beppe.leetcode.window;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo1 {

    @Test
    public void test1() {
//        int len = lengthOfLongestSubstring("beppezhang");
//        System.out.println("len:" + len);
        int[] arr=new int[]{1,6,7,9};
        int i = maxArea(arr);
        System.out.println("max:"+i);
    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        // 左索引
        int right = 0;
        for (int left = 0; left < s.length(); left++) {
            // 左索引每加一次  set remove left 的前一个元素
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    private int maxArea(int[] height) {
        int maxNum = 0;
        int left = 0, right = height.length-1;
        while (right > left) {
            // 计算大小
            int res = (right - left) * Math.min(height[right], height[left]);
            maxNum = Math.max(maxNum, res);
            if(height[right]>height[left]){
                left++;
            }else {
                right++;
            }
        }
        return maxNum;
    }
}
