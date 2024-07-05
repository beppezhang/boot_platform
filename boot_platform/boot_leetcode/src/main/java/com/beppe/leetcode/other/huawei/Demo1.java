package com.beppe.leetcode.other.huawei;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Demo1 {

    @Test
    public void test1(){
        Scanner in = new Scanner(System.in);
        System.out.println("输入一个字符串");
        String str=in.nextLine();
        System.out.println("str:"+str);
    }
    //计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
    private int getLength(String str){
        String[] s = str.split("\n");
        String s1 = s[s.length - 1];
        System.out.println();
        return s1.length();
    }
}
