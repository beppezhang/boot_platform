package com.beppe.leetcode.tree;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

public class Demo1 {
    private static TwoTreeNode treeNode;

    static {
        TwoTreeNode node1 = new TwoTreeNode(6, new TwoTreeNode(2, null, null), new TwoTreeNode(7, null, null));
        TwoTreeNode node2 = new TwoTreeNode(14, new TwoTreeNode(9, null, null), new TwoTreeNode(18, null, null));
        treeNode = new TwoTreeNode(8, node1, node2);
    }

    @Test
    public void test1() {
        //
//        List<Integer> res = Lists.newArrayList();
//        traverse(treeNode, res);
//        System.out.println("获取到的结果：" + res);
        int i = maxDepth(treeNode);
        System.out.println("最深的树是："+i);
    }

    @Test
    public void test2(){
        int record=0;
        int max=0;
        maxDepthIterator(treeNode,record,max);
        System.out.println("树高,"+record);
    }

    private void traverse(TwoTreeNode node, List res) {
        if (node == null) {
            return;
        }
        traverse(node.left, res);
        System.out.println("打印出的节点数据," + node.val);
        res.add(node.val);
        traverse(node.right, res);
    }

    private int maxDepth(TwoTreeNode node){
        if(node==null){
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        int max = Math.max(leftDepth, rightDepth);
        System.out.println("树的深度,"+max);
        return max+1;
    }

    // record 记录遍历到的节点
    private void maxDepthIterator(TwoTreeNode node,int record,int max){
        if(node==null){
            // 叶子节点
            System.out.println("到达叶子节点："+record);
            return;
        }
        record++;
        maxDepthIterator(node.left,record,max);
        maxDepthIterator(node.right,record,max);
        record--;
    }
}
