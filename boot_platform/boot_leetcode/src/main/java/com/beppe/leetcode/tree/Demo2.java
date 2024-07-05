package com.beppe.leetcode.tree;

import org.testng.annotations.Test;

public class Demo2 {

    int maxDiameter=0;
    static TwoTreeNode node;
    static {
        // 构造二叉树
        TwoTreeNode node1=new TwoTreeNode(4,new TwoTreeNode(12,null,null),new TwoTreeNode(13,new TwoTreeNode(10,null,null),null));
        TwoTreeNode node2=new TwoTreeNode(7,new TwoTreeNode(8,null,null),new TwoTreeNode(9,null,null));
        node=new TwoTreeNode(5,node1,node2);
    }

    @Test
    public void test1(){
        //  二叉树的最大深度   max(左子树,右子树)+1
//        int left = maxDepth(node.left);
//        int right = maxDepth(node.right);
//        int i = maxDepth(node);
//        System.out.println("最大直径:"+i);
        rotateTree(node);

    }




    private int maxDepth(TwoTreeNode node){
        if (node == null) {
            return 0;
        }
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }


    // 翻转二叉树
    private void rotateTree(TwoTreeNode node){
        if(node==null){
            return;
        }
        TwoTreeNode left = node.left;
        node.left=node.right;
        node.right=left;
        rotateTree(node.left);
        rotateTree(node.right);

    }



}
