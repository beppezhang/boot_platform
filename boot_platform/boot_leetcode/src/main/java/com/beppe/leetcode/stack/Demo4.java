package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo4 {

    @Test
    public void test1(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("pop出来的数据3:"+myStack.pop());
        System.out.println("pop出来的数据2:"+myStack.pop());
        System.out.println("pop出来的数据1:"+myStack.pop());

    }

    // 队列实现栈
    public class MyStack{

        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();

        // 需要保证先进先出  queue1  维护最新的一个元素
        public void push(Integer i){
            queue2.offer(i);
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            // 两个队列交换
            Queue<Integer> tmp=queue2;
            queue2=queue1;
            queue1=tmp;

        }

        public Integer pop(){
            return queue1.poll();
        }

    }

}
