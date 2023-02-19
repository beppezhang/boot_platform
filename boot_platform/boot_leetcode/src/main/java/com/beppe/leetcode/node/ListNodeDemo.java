package com.beppe.leetcode.node;

import org.testng.annotations.Test;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 */
public class ListNodeDemo {

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
//        ListNode listNode = rotateNode(l5, 1);
//        ListNode listNode = copyNode(l5);
        ListNode listNode = removeN(l5, 2);

    }

    public ListNode rotateNode(ListNode head, int n) {
        // 计算出链表长度
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        //头尾相连
        cur.next = head;
        // 计算断开的位置
        int pos = len - n % len;
        while (pos > 1) {
            pos--;
            head = head.next;
        }
        ListNode result = head.next;
        head.next = null;
        return result;

    }

    private ListNode copyNode(ListNode head) {
        ListNode cur = new ListNode(0, null);
        ListNode dummy = new ListNode(0, cur);
        while (head != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
        }
        return dummy.next.next;
    }

    private ListNode reverseNode(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next =cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;

    }

    // 删除链表倒数第n个
    private ListNode removeN(ListNode node,int k){
        // 遍历链表到第K个
        ListNode p1=node;
        ListNode p2=node;
        for (int i=0;i<k;i++){
            p1=p1.next;
        }
        while (p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return node;

    }


    private ListNode mergeTwoLists(ListNode ln1,ListNode ln2){
        
        return null;
    }


}
