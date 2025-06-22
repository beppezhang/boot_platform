package com.beppe.leetcode.stack;

import java.util.Stack;

public class Myqueue {

    Stack<Integer> stack1=new Stack();
    Stack<Integer> stack2=new Stack();

    // stack1 维护所有元素   stack2 仅维护最新的元素  保证先进后出
    public void push(int e){
        stack1.push(e);
        if(stack2.size()==0){
            stack2.push(e);
        }else {
            stack2.pop();
            stack2.push(e);
        }
    }

    public void pop(){
        stack2.pop();
    }

//    public int peek(){
//
//    }
}
