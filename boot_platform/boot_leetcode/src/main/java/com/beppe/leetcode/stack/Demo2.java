package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.*;

public class Demo2 {

    @Test
    public void test1(){
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode tree = new TreeNode(1,left,right);
        iteratorMid(tree);
    }

    /**
     * 二叉树中序遍历  左  中  右
     * 加入数据元素的时机  pop 后加入列表
     */
    private void iteratorMid(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        while (root!=null || stack.size()>0){
            // 将左节点遍历到底
            while (root!=null){
                // 入栈
                stack.push(root);
                root=root.left;
            }
            // 出栈  遍历右节点
            TreeNode pop = stack.pop();
            res.add(pop.val);
            // 设置为右节点
            root=pop.right;
        }
        System.out.println("树的节点值:"+res);
    }

    /**
     * 使用栈实现
     * 二叉树 前序遍历  中 左  右
     * 加入数据的时机 入栈前
     */
    private void iteratorFront(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        while (root!=null || stack.size()>0){
            // 将左节点遍历到底
            while (root!=null){
                //加入到结果集中
                res.add(root.val);
                // 入栈
                stack.push(root);
                root=root.left;
            }
            // 遍历右节点
            TreeNode pop = stack.pop();
            root=pop.right;

        }
    }


    /**
     * 使用栈实现
     * 二叉树 后序遍历  左    右     中
     *
     */
    private void iteratorBack(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        while (root!=null || stack.size()>0){
            // 将左节点遍历到底
            while (root!=null){
                //加入到结果集中
                // 入栈
                stack.push(root);
                root=root.left;
            }
            // 出栈
            stack.pop();
        }
    }


    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
