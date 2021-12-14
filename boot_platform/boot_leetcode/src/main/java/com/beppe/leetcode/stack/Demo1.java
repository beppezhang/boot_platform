package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo1 {

    @Test
    public void test1() {
        boolean valid = valid("(){}{[[]}]");
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

    private Map<Character, Character> add() {
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        return map;
    }
}
