package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> nqueue=new LinkedList<>();
    Deque<Integer> minqueue=new LinkedList<>();

    public MinStack(){
        minqueue.push(Integer.MAX_VALUE);
    }

    public void push(int e){
        nqueue.push(e);
        minqueue.push(Math.min(minqueue.peek(),e));
    }

    public Integer pop(){
       return nqueue.pop();
    }
    
    public Integer peek(){
        return nqueue.peek();
    }

    public Integer min(){
        return minqueue.peek();
    }
    
    @Test
    public void test1(){
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
//        Integer peek = minStack.peek();
        System.out.println("peek:"+minStack.min());

    }
}
