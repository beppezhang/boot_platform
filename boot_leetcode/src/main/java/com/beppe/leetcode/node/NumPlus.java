package com.beppe.leetcode.node;

/**
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class NumPlus {

    public ListNode getTwoNum(ListNode l1, ListNode l2) {
        // 使用while 的形式来做
        // 使用哑节点来维护后续使用链表
        ListNode head=null,tail=null;
        int carry=0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum=v1+v2+carry;
            // 使用head 节点来维护最终的指针
            if(head==null){
                head=new ListNode(sum%10,null);
                tail=new ListNode(sum%10,null);
            }else {
                tail.next=new ListNode(sum%10,null);
            }
            carry=sum/10;
            if(l1!=null){
               l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            tail.next= new ListNode(carry,null);
        }
        return head;
    }
}
