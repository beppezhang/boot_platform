package com.beppe.test;

import java.util.LinkedList;

/**
 * 删除链表的倒数第 N 个结点
 */
public class Alothg {

    public ListNode removeN(ListNode ln, int n) {
        ListNode dummy = new ListNode(0, ln);
        // 计算出链表长度
        int lenth = getLenth(dummy);
        ListNode cur=dummy;
        // 需要删除的位置
        int pos = lenth - n +1;
        for (int i = 1; i <pos ; i++) {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }

    // 链表反转
    public ListNode rotateRight(ListNode ln,int n) {
        return null;

    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {

            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    private int getLenth(ListNode ln){
        int len=0;
        while (ln!=null){
            len++;
            ln=ln.next;
        }
        return len;
    }
}
