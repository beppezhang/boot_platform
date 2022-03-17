package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo1 {

    @Test
    public void test1() {
        boolean valid = isValidate("(){}{[[]}]");
        System.out.println("valid:"+valid);
    }

    private boolean valid(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = add();
        for (int i = 0; i < str.length();i++ ){
            if(map.containsValue(str.charAt(i))){
                stack.push(str.charAt(i));

            }
            if(map.containsKey(str.charAt(i))){
                if(stack.size()==0){
                    return false;
                }
                    Character pop = stack.pop();
                    if(pop!=map.get(str.charAt(i))){
                        return false;
                    }


            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }

    // 左右括号映射
    private Map<Character, Character> add() {
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        return map;
    }


    /**
     * 使用栈判断是否有效括号
     *   1:先进先出   '(' 进栈     ')'  出栈
     *   2: 出栈 时  栈中无数据  无效
     *   3： 出栈结束  栈中还有数据  无效
     * @return
     */
    public boolean isValidate(String str){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = add();
        for (int i=0;i<str.length();i++){
            if(map.containsValue(str.charAt(i))){
                stack.push(str.charAt(i));
            }
            if(stack.size()==0){
                return false;
            }
            if(stack.pop()!=str.charAt(i)){
                return false;
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
     */
//    private boolean getMaxLength(String str){
//        int maxLength=0;
//        //用于存储  '('  ')'
//        Stack<Character> stack = new Stack<>();
//        // 记录循环次数
//        int num=0;
//        for (int i = 0; i < str.length(); i++) {
//            // 判断是否是合法字符
//
//        }
//    }

//    private boolean isLegalChar(Stack<Character> stack,Character c){
//
//    }
}
