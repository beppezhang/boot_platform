package com.beppe.leetcode.tree;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Demo1 {
    int step=0;
    int maxDep=0;

    static TwoTreeNode node;
    static {
        // 构造二叉树
        TwoTreeNode node1=new TwoTreeNode(4,new TwoTreeNode(12,null,null),new TwoTreeNode(13,null,null));
        TwoTreeNode node2=new TwoTreeNode(7,new TwoTreeNode(8,null,null),new TwoTreeNode(9,null,null));
        node=new TwoTreeNode(5,node1,node2);
    }

    static TwoTreeNode node10;
    static {
        // 构造二叉树
        TwoTreeNode node11=new TwoTreeNode(4,new TwoTreeNode(12,null,null),null);
        node10=new TwoTreeNode(5,node11,null);
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

    // 前序遍历二叉树
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

    @Test
    public void test3(){
        //一次遍历  二叉树最大路径

         maxDepth(node);
        System.out.println("结果:"+maxDep);
    }

    private void maxDepth(TwoTreeNode root){

        if(root==null){
            // 更新最大深度
            maxDep=Math.max(step,maxDep);
            return;
        }
        // 进入二叉树,记录执行的步骤
        step++;
        maxDepth(root.left);
        maxDepth(root.right);
        // 离开二叉树  记录的步骤减1
        step--;
    }

    List<Integer> res=new LinkedList<>();

    @Test
    public void test4(){
        //获取二叉树遍历结果
        traverse(node);
        System.out.println("res:"+res);
    }
    private void traverse(TwoTreeNode root){
        if (root==null){
          return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    @Test
    public void maxDepthTest(){
        // 最大深度
        int aa=maxDepth1(node);
        System.out.println("aa:"+aa);
    }

    private int maxDepth1(TwoTreeNode root){
        if(root==null){
            return 0;
        }
        // 左子树
        int left=maxDepth1(root.left);
        int right=maxDepth1(root.right);
        return Math.max(left,right)+1;
    }

    int maxDimon=0;
    @Test
    public void test5(){
//        // 最大直径  max(左深度+右深度)
//        int i = maxDimon(node10);
//        maxDimon=maxDimon+1;// 直径加上自身的节点
        turnTree1(node);
        System.out.println("aa");
    }

    // 节点  max(左子树+右子树)

    private int maxDimon(TwoTreeNode root){
        if(root==null){
            return 0;
        }
        // 左子树
        int left=maxDimon(root.left);
        int right=maxDimon(root.right);
        maxDimon=Math.max((left+right),maxDimon);
        return Math.max(left,right)+1;
    }


    // 翻转二叉树
    private void turnTree(TwoTreeNode root){
        if(root==null){
            return;
        }
        // 左节点变更为右节点
        TwoTreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        // 对左节点操作翻转
        turnTree(root.left);
        // 对右节点操作翻转
        turnTree(root.right);
    }

    // 翻转二叉树
    private TwoTreeNode turnTree1(TwoTreeNode root){
        if(root==null){
            return null;
        }
        // 翻转左   得到左子树翻转后结果
        TwoTreeNode left=turnTree1(root.left);
        // 翻转右
        TwoTreeNode right=turnTree1(root.right);
        // 具体的翻转方法  替换左右子树
        root.right=left;
        root.left=right;
        return root;
    }

    @Test
    public void test6(){
        flatTree(node);
    }

    // 将二叉树拉平
    private void flatTree(TwoTreeNode root){
        if(root==null){
            return;
        }
        // 将左右子树拉平
        flatTree(root.left);
        flatTree(root.right);
        TwoTreeNode left = root.left;
        TwoTreeNode right = root.right;
        // 将左子树放到右子树
        root.left=null;
        root.right=left;
        //将现在右子树的末端连上原先右字树
        TwoTreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }

    @Test
    public void test7(){
        // 将二叉树序列化
        LinkedList<Integer> res = Lists.newLinkedList();
        serialize(node,res);
        System.out.println("序列化后结果:"+res);
        //
        TwoTreeNode node = deSerialize(res);
        System.out.println("反序列化结果:"+node);
    }

    // 序列化二叉树
    private void serialize(TwoTreeNode root,List<Integer> res){
        // 节点为空  -1
        if(root==null){
            res.add(-1);
            return;
        }
        // 添加元素
        res.add(root.val);
        // 前序遍历
        serialize(root.left,res);
        serialize(root.right,res);
    }

    // 反序列化二叉树   前序遍历
    private TwoTreeNode deSerialize(LinkedList<Integer> res){
        if(res.isEmpty()){
            return null;
        }
        // 找到根节点
        Integer val = res.removeFirst();
        if(val==-1){
            return null;
        }
        TwoTreeNode root=new TwoTreeNode();
        root.val=val;
        root.left=deSerialize(res);
        root.right=deSerialize(res);
        return null;

    }


}
