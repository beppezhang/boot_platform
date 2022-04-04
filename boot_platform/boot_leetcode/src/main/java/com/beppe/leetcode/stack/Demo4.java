package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Demo4 {

    @Test
    public void test1() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("pop出来的数据3:" + myStack.pop());
        System.out.println("pop出来的数据2:" + myStack.pop());
        System.out.println("pop出来的数据1:" + myStack.pop());

    }

    public boolean isHuiwenNode(ListNode root){
        int len = getLen(root);
        // 计算 入栈结束索引   出栈开始索引
        int end = len/2;
        int a=len%2;
        // 遍历
        int time=0;
        Stack<Integer> stack = new Stack();
        while (root!=null){
            //未过半加入栈
            if(time<end){
                stack.push(root.val);
            }
            else {
                // 偶数判断
                if(a==0){
                    boolean b = stack.pop() == root.val;
                    if(!b){
                        return false;
                    }
                }else {
                    // 奇数判断
                    if(time==len){
                        root=root.next;
                        time++;
                        continue;
                    }else {
                        boolean b = stack.pop() == root.val;
                        if(!b){
                            return false;
                        }
                    }
                }
            }
            time++;

            root=root.next;
        }
        return stack.size()==0;
    }

    private int getLen(ListNode root){
        ListNode cur=root;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }




    // 队列实现栈
    public class MyStack {

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        // 需要保证先进先出  queue1  维护最新的一个元素
        public void push(Integer i) {
            queue2.offer(i);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            // 两个队列交换
            Queue<Integer> tmp = queue2;
            queue2 = queue1;
            queue1 = tmp;

        }

        public Integer pop() {
            return queue1.poll();
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
