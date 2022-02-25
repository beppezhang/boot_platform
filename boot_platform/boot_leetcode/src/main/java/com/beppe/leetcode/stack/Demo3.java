package com.beppe.leetcode.stack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo3 {

    @Test
    public void test1() {

    }

    /**
     * 二叉树前序遍历    左  中  右   使用栈
     */
    private List<Integer> iteratorFront(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 先遍历左节点   再遍历右节点
        while (node != null ||stack.size()>0) {
            //遍历左树
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                // 添加节点
                TreeNode pop = stack.pop();
                result.add(pop.val);
                //遍历右树
                node=pop.right;
            }
        }
        return result;
    }


    /**
     * 二叉树前序遍历    左  中  右   使用栈
     */
    private List<Integer> iteratorMid(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 先遍历左节点   再遍历右节点
        while (node != null ||stack.size()>0) {
            //遍历左树
            if (node != null) {
                // 添加结果
                result.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                // 添加节点
                TreeNode pop = stack.pop();
                //遍历右树
                node=pop.right;
            }
        }
        return result;
    }

    /**
     * 二叉树后序遍历    左   右   中   使用栈
     */
    private List<Integer> iteratorBack(TreeNode node) {
        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
