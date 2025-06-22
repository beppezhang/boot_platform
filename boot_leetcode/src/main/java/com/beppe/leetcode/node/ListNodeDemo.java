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
//        ListNode listNode = findN(l5, 2);
        reverseNode(l5);


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
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=head;
        while (cur!=null){
            next=cur.next;
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

    @Test
    public void test2(){
        // 合并两个有序链表
        ListNode node1=new ListNode(1,new ListNode(3,new ListNode(8,null)));
        ListNode node2=new ListNode(2,new ListNode(5,null));
        ListNode listNode = mergeTwoNodes(node1, node2);
    }

    private ListNode mergeTwoNodes(ListNode node1,ListNode node2){
//        ListNode dummy=new ListNode(-1);
//        ListNode p=dummy;
//        while (node1!=null && node2!=null){
//            if(node1.val<node2.val){
//                p.next=node1;
//                node1=node1.next;
//
//            }else {
//                p.next=node2;
//                node2=node2.next;
//
//            }
//            p=p.next;
//
//        }
//        if(node1!=null){
//            p.next=node1;
//        }
//        if(node2!=null){
//            p.next=node2;
//        }
//        return dummy.next;
        // 设置哑节点
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        // 遍历链表
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                // 取node1 的值
                p.next=node1;
                node1=node1.next;
                p=p.next;
            }else {
                // 取node2 的值
                p.next=node2;
                node2=node2.next;
                p=p.next;
            }
        }
        if(node1!=null){
            p.next=node1;
        }
        if(node2!=null){
            p.next=node2;
        }
        return dummy.next;
    }



    private ListNode mergeTwoLists(ListNode ln1,ListNode ln2){
        
        return null;
    }

    @Test
    public void test3(){
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l3);
        ListNode l7 = new ListNode(7, l6);

        ListNode res=getIntersection(l5,l6);
    }

    // 正向找到第K 个元素
    private ListNode findK(ListNode node,int k){
        // 遍历第K 次即可
        ListNode head=node;
        int count=0;
        while (node!=null){
            if(count==k){
               break;
            }
            node=node.next;
            count++;
        }
        // node 走到尾部  head 从头开始走
        while (node!=null){
            node=node.next;
            head=head.next;
        }
        return head;
    }

    private ListNode findMid(ListNode node){
        // 快指针步长 2  慢指针步长 1  快指针走完  慢指针走到中间
        ListNode slow=node;
        ListNode fast=node;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast!=null){
                slow=slow.next;
            }

        }
        return slow;
    }

    // 链表是否包含环
    private boolean isInCircle(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        // 快指针为null  返回false   快指针==慢指针  返回true
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    // 两个链表是否相交  返回相交节点
    private ListNode getIntersection(ListNode node1,ListNode node2){
        if(node1==null || node2==null){
            return null;
        }
        ListNode p1=node1;
        ListNode p2=node2;
        while (p1!=p2){
            if(p1==null){
                p1=node2;
            }
            if (p2==null){
                p2=node1;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }


}
