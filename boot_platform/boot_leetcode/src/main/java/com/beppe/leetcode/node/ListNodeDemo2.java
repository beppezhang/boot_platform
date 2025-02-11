package com.beppe.leetcode.node;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ListNodeDemo2 {

    @Test
    public void test1() {
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode4 = new ListNode(3, null);
        ListNode listNode5 = new ListNode(2, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);
//        ListNode result = reverse(listNode1);
//        ListNode listNode = numAdd(listNode1, listNode6);
//        boolean palindrome = isPalindrome(listNode1);
        ListNode listNode = reverse1(listNode1);
        System.out.println("result:" + listNode);

    }

    // 反转链表  使用栈  遍历链表  将元素放入栈中
    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode numAdd(ListNode node1, ListNode node2) {
        ListNode header = null;
        ListNode tail = null;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int num1 = node1 == null ? 0 : node1.val;
            int num2 = node2 == null ? 0 : node2.val;
            int sum = num1+num2+carry;
            carry = sum / 10;
            if (header == null) {
                header=tail=new ListNode(sum%10,null);
            } else {
                tail.next=new ListNode(sum%10,null);
                tail=tail.next;
            }
            if(node1!=null){
                node1=node1.next;
            }
            if(node2!=null){
                node2=node2.next;
            }
        }
        if(carry>0){
            tail.next=new ListNode(carry,null);
        }
        return header;
    }

    // 判断是否使回文链表

    /**
     * 通过维护一个栈和队列   出栈和出队列值完全一样
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        while (head!=null){
            stack.push(head.val);
            queue.offer(head.val);
            head=head.next;
        }
        // 出栈  出队列
        while (stack.size()>0){
            if(stack.pop()!=queue.poll()){
                return false;
            }
        }
        return true;
    }

    // 反转链表
    private ListNode reverse1(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        // 遍历链表
        while (cur!=null){
            // 先保存cur 后继节点
            ListNode next= cur.next;
            //当前节点next 指向 pre
            cur.next=pre;
            // pre 向前推进一个
            pre=cur;
            // cur 向前推进一个
            cur=next;
        }
        return pre;

    }

    private ListNode removeEndN(ListNode head,int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        // 删除倒数N 则需要找到倒n+1
        ListNode endN = findEndN(dummy, n + 1);
        endN.next=endN.next.next;
        return dummy.next;
    }


    // 删除倒数第N
    private ListNode findEndN(ListNode head,int n){
        //
        ListNode p=head;
        ListNode l=head;
        // p 走n步
        for (int i = 1; i <=n ; i++) {
            p=p.next;
        }
        // p 走到头   l 从头开始走
        while (p!=null){
            p=p.next;
            l=l.next;
        }
        return l;
    }


}
