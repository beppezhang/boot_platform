package com.beppe.leetcode.tree;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

public class Demo1 {
    static TwoTreeNode node;
    static {
        // 构造二叉树
        TwoTreeNode node1=new TwoTreeNode(4,new TwoTreeNode(12,null,null),new TwoTreeNode(13,null,null));
        TwoTreeNode node2=new TwoTreeNode(7,new TwoTreeNode(8,null,null),new TwoTreeNode(9,null,null));
         node=new TwoTreeNode(5,node1,node2);
    }

    @Test
    public void test1(){
        // 构造一颗二叉树
        List<Integer> res = Lists.newArrayList();
        traverse(node,res);
        System.out.println("遍历后结果,"+res);
    }

    @Test
    public void test2(){
        // 二叉树最大路径和
        int res=0;
        int aa = oneSideMax(node);
        System.out.println("遍历后结果,"+aa);
    }

    // 前序便利二叉树
    private void traverse(TwoTreeNode treeNode, List<Integer> res){
        if(treeNode==null){
            return;
        }
        traverse(treeNode.left,res);
        res.add(treeNode.val);
        System.out.println("当前树的节点数据,"+treeNode.val);
        traverse(treeNode.right,res);

    }

    private int oneSideMax(TwoTreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        //左树最大路径
        int left=Math.max(0,oneSideMax(treeNode.left));
        // 右数最大路径
        int right=Math.max(0,oneSideMax(treeNode.right));
        // 最大路径=左树做大路径+右树最大路径+当前节点
//        res=Math.max(res,left+right+treeNode.val);
        return Math.max(left,right)+treeNode.val;
    }
}
