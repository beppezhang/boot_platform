package com.beppe.leetcode.window;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.testng.annotations.Test;

import java.util.*;

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

    @Test
    public void test2(){
        int length = lengthOfLongestSubstring11("abbcfdsd");
        System.out.println("minSub："+length);
    }

    // 最小字串 如 s="abcfdsd"  t=bcs  则返回 bcfds
    private String getMinSub(String s,String t){
        // 2  滑动窗口   左右指针
        int left=0;int right=0;
        int valid=0; int len=Integer.MAX_VALUE;  int start=0;
        Map<Character,Integer> need= Maps.newHashMap();
        Map<Character,Integer> window= Maps.newHashMap();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),1);
        }
        // 处理滑动窗口
        while (right<s.length()){
            char c = s.charAt(right);
            // 扩大区间
            right++;
            if(need.containsKey(c)){
                // b 加入 window
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c)==window.get(c)){
                    valid++;
                }
            }
            // 缩小区间  valid ==need  长度，则表明window  包含了所有的元素  可以缩小区间   即 left++
            while (valid == need.size()){
                // 更新结果
                if(right-left<len){
                    start=left;
                    len=right-left;
                }

                //将window 数据更新
                char leftC = s.charAt(left);
                left++;
                if(window.containsKey(leftC)){
                    if(window.get(leftC)==need.get(leftC)){
                        // valid 自减
                        valid--;
                    }
                    // 更新window 的数据
                    window.put(leftC,window.get(leftC)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    // 无重复的最大字符串  abbcfdsd
    private int lengthOfLongestSubstring11(String str){
        int left=0,right=0;
        Map<Character,Integer> window= Maps.newHashMap();
        int res=0;
        while (right<str.length()){
            char c = str.charAt(right);
            // 增加窗口
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            // 缩小窗口 有重复字符串需要缩小
            while (window.getOrDefault(c,0)>1){
                char c1 = str.charAt(left);
                left++;
                window.put(c1,window.get(c1)-1);
            }
            res=Math.max(res,right-left);
        }
        return res;
    }

    // 无重复的最大字符串  abbcfdsd
    private int lengthOfLongestSubstring12(String str){
        // 维护左右索引
        int left=0,right=0;
        // 维护窗口
        Map<Character,Integer> window=new HashMap<>();
        int res=0;
        while (right<str.length()){
            char rightChar=str.charAt(right);
            window.put(rightChar,window.getOrDefault(rightChar,0)+1);
            while (window.get(rightChar)>1){
                // 删除左索引
                window.remove(left);
                // 缩小左索引
                left++;

            }
            // 记录一次遍历后的长度
            res=Math.max(res,right-left);
        }
        return res;
    }

}
