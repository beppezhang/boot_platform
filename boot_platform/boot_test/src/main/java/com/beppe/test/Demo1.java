package com.beppe.test;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Demo1 {

    @Test
    public void test1(){
        // 栈
        Stack<String> stack= new Stack();
        stack.push("beppe1");
        stack.push("beppe2");
        stack.push("beppe3");
        String peek = stack.pop();
        System.out.println("peek:"+peek);

        // 队列
        Deque<String> queue=new LinkedList();
        queue.push("beppe1");
        queue.push("beppe2");
        queue.push("beppe3");
        String poll = queue.pop();
        System.out.println("poll:"+poll);
    }
}
