package com.beppe.leetcode.hash;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个唯一字符
 */
public class FirstChar {

    @Test
    public void test1(){
        int indx = firstChar1("leetcode");
        System.out.println("第一次的索引:"+indx);
    }

    // 维护一个map  key  字符   value  出现的次数
    public int firstChar1(String str) {
        Map<Character,Integer> map=new HashMap();
        // 第一次遍历放置字符  和  出现的次数
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);

        }
        // 第二次遍历  获取最早出现次数是1 的字符
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.get(c)==1){
                return i;
            }

        }
        return -1;
    }
}
