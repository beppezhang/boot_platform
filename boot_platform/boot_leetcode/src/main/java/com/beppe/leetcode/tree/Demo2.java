package com.beppe.leetcode.tree;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    private static TwoTreeNode treeNode;

    private int init=-1;
    private int res=0;

    static {
        TwoTreeNode node1 = new TwoTreeNode(2, new TwoTreeNode(1, null, null), new TwoTreeNode(4, null, null));
        TwoTreeNode node2 = new TwoTreeNode(7, new TwoTreeNode(6, null, null), new TwoTreeNode(8, null, null));
        treeNode = new TwoTreeNode(5, node1, node2);
    }

    @Test
    public void test1(){
        // BST
//        List<Integer> res = Lists.newArrayList();
//        traverse(treeNode,res);
//        System.out.println("res:"+res);
//        findKMin(treeNode,3);
//        System.out.println("res:"+res);
        traverse1(treeNode);
    }

    private void traverse(TwoTreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        traverse(root.left,res);
        res.add(root.val);
        traverse(root.right,res);
    }

    private void findKMin(TwoTreeNode root,int k){
        if(root==null){
            return;
        }
        findKMin(root.left,k);
        init++;
        if((init+1)==k){
            res=root.val;
            return;
        }
        findKMin(root.right,k);
    }

    private void traverse1(TwoTreeNode root){
        if(root==null){
            return;
        }
        traverse1(root.right);
        System.out.println("降序排列:"+root.val);
        // 记录节点累加数据
        res+=root.val;
        root.val=res;
        traverse1(root.left);
    }

    boolean flag=false;
    @Test
    public void test2(){
        boolean validateBST = isValidateBST(treeNode,null,null);
        System.out.println("validateBST:"+validateBST);
//        inBST(treeNode,7);
//        System.out.println("flag:"+flag);
    }

    // 判断是否BST  根节点大于左子树所有节点 小于右子树所有节点 min  最小节点(遍历右树为根节点)  max最大节点(遍历左树为根节点)
    private boolean isValidateBST(TwoTreeNode root,TwoTreeNode min,TwoTreeNode max){
        if(root==null){
            return true;
        }
        // 左节点小于最大
        if(min!=null && min.val>root.val) return false;
        if(max!=null && max.val<root.val) return false;
        // 左节点
        boolean left = isValidateBST(root.left,min,root);
        boolean right = isValidateBST(root.right,root,max);
        return left && right;
    }


    private void inBST(TwoTreeNode root,int target){
        if(flag){
            return;
        }
        if(root==null){
            return;
        }
        if(root.val==target){
            flag=true;
        }
        // 遍历左树
        inBST(root.left,target);
        // 遍历右树
        inBST(root.right,target);
    }

    private boolean inBST1(TwoTreeNode root,int target){
        if(root==null){
            return false;
        }
        // 找到target
        if(root.val==target){
            return true;
        }
        // root>target  遍历左子树
        if(root.val>target){
            return inBST1(root.left,target);
        }
        // root<target  遍历右子树
        if(root.val<target){
            return inBST1(root.right,target);
        }
        return false;

    }

    @Test
    public void test3(){
//        traverse(treeNode);
        count(1,5);
    }

    private void traverse(TwoTreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }

    /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
    int count(int lo, int hi) {
        // base case
        if (lo > hi) return 1;

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i 的值作为根节点 root
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }

        return res;
    }

    // 快排   lo 数组开始   li 数组结束  [4,2,1,3,8,6]
    private void quickSort(int[] arr,int lo,int li){
        if(arr==null || arr.length==0){
            return;
        }
        if(lo>=li){
            return;
        }
        // 找出元素对应的索引

    }

    @Test
    public void test5(){ //  2 1 3 5 4
        int[] arr={4,5,3,2,1};
        partition(arr,0,4);
    }

    // 找出 arr[0]  正确位置的索引  [4,2,1,5,3]
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }



    // 原地交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}





