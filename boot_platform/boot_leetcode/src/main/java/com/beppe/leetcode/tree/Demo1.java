package com.beppe.leetcode.tree;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {
    private static TwoTreeNode treeNode;

    private int maxDiameter=0;

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

    @Test
    public void test3(){
//        int i = maxDepth1(treeNode);
//        System.out.println("最大直径:"+maxDiameter);
//        TwoTreeNode twoTreeNode = rotateNodeAfter(treeNode);
//         flatNode(treeNode);
        int[] arr={1,5,3,7,6,4,1};
        TwoTreeNode twoTreeNode = buildMaxTree(arr, 0, arr.length - 1);
    }

    // 最大直径
    private int maxDepth1(TwoTreeNode node){
        if(node==null){
            return 0;
        }
        // 左节点最大深度
        int leftMax = maxDepth1(node.left);
        // 右节点最大深度
        int rightMax = maxDepth1(node.right);
        // 计算最大直径
        maxDiameter = leftMax+rightMax+1;
        return Math.max(leftMax,rightMax)+1;
    }

    // 翻转二叉树  以根节点左右交换
    private void rotateNode(TwoTreeNode node){
        // 前序方式   一次遍历获取结果
        // 左右对调子节点
        if(node==null){
            return;
        }
        exchangeChildNode(node);
        // 遍历下个节点
        rotateNode(node.left);
        rotateNode(node.right);
    }

    // 翻转二叉树  后序方式
    private TwoTreeNode rotateNodeAfter(TwoTreeNode node){
        // 后序方式  通过操作子树结果
        if(node==null){
            return null;
        }
        // 翻转后的左子树
        TwoTreeNode left = rotateNodeAfter(node.left);
        // 翻转后的右子树
        TwoTreeNode right = rotateNodeAfter(node.right);
        // 当前节点左右子树对调
        node.left=right;
        node.right=left;
        return node;

    }
    private void exchangeChildNode(TwoTreeNode node){
        TwoTreeNode temp = node.left;
        node.left=node.right;
        node.right=temp;
    }

    // 按前序顺序将树拉直
    private void flatNode(TwoTreeNode node){
        if(node==null){
            return;
        }
        // 左子树拉直
        flatNode(node.left);
        // 右子树拉直
        flatNode(node.right);
        // 拉直后左节点置空  右节点拉平
        TwoTreeNode left = node.left;
        TwoTreeNode right = node.right;
        node.left=null;
        node.right=left;
        TwoTreeNode p=node;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }

    //构建最大二叉树  给定数组构建最大二叉树  数据 arr  [lo……li]
    private TwoTreeNode buildMaxTree(int[] arr,int lo,int li){
        if(lo>li){
            return null;
        }
        // 1 找到最大的元素作为root
        int maxIndex = findMaxIndex(arr,lo,li);
        // 构建根节点
        TwoTreeNode root=new TwoTreeNode(arr[maxIndex]);
        //构建最大左子树
        root.left = buildMaxTree(arr,lo,maxIndex-1);
        // 构建最大右子树
        root.right = buildMaxTree(arr,maxIndex+1,li);
        return root;
    }

    private int findMaxIndex(int[] arr,int lo,int li){
        int value=Integer.MIN_VALUE;
        int index=-1;
        for (int i = lo; i <= li; i++) {
            if(arr[i]>value){
                value=arr[i];
                index=i;
            }
        }
        return index;
    }

    @Test
    public void test4(){
//        int[] preOrder={8,6,2,7,14,9,18};
//        int[] inOrder ={2,6,7,8,9,14,18};
//        TwoTreeNode root = buildNode(preOrder, 0, preOrder.length - 1,
//                inOrder, 0, inOrder.length - 1);
//        StringBuilder sb = new StringBuilder();
//        serialize(treeNode,sb);
//        System.out.println("node序列化后:"+sb.toString());
        String str="8,6,#,#,14,#,#,7,#";
        String[] split = str.split(",");
        LinkedList<String> list = Lists.newLinkedList();
        for (String aa:split){
            list.add(aa);
        }
        TwoTreeNode twoTreeNode = deSerialize(list);
    }

    // 前序中序构造二叉树
    private TwoTreeNode buildNode(int[] preOrder,int preStart,int preEnd,
                                    int[] inOrder,int inStart, int inEnd){
        if(preStart>preEnd){
            return null;
        }
        // 计算出 inOrder 中的root 索引  用来确定preEnd
        int rootIndex = getRootIndex(preOrder[preStart], inOrder);
        int leftSize = rootIndex-inStart;
        // 构建根节点
        TwoTreeNode root = new TwoTreeNode(preOrder[preStart]);
        // 构建左子树
        root.left = buildNode(preOrder,preStart+1,preStart+leftSize,inOrder,inStart,rootIndex-1);
        // 构建右子树
        root.right = buildNode(preOrder,preStart+leftSize+1,preEnd,inOrder,rootIndex+1,inEnd);
        return root;
    }

    private int getRootIndex(int rootVal,int[] inOrder){
        for (int i = 0; i <inOrder.length ; i++) {
            if(rootVal==inOrder[i]){
                return i;
            }
        }
        return -1;
    }

    private void serialize(TwoTreeNode node,StringBuilder sb){
        // base case
        if(node==null){
            sb.append("#");
            sb.append(",");
            return;
        }
        // 前序遍历
        sb.append(node.val);
        sb.append(",");
        serialize(node.left,sb);
        serialize(node.right,sb);
    }

    private TwoTreeNode deSerialize(LinkedList<String> list){
        if(list==null){
            return null;
        }
        String s = list.removeFirst();
        // 构建根节点
        if("#".equals(s)){
            return null;
        }
        TwoTreeNode root = new TwoTreeNode(Integer.parseInt(s));
        // 构建左树
        root.left=deSerialize(list);
        // 构建右树
        root.right=deSerialize(list);
        return root;

    }

    @Test
    public void test5(){

    }

    // 归并算法
    private void sortArr(int[] arr,int start,int end){
        // 获取中间位置
        int middle = (start+end)/2;
        // 左边部分
        sortArr(arr,start,middle);
        // 右部分
        sortArr(arr,middle+1,end);
        // 合并
    }

}
