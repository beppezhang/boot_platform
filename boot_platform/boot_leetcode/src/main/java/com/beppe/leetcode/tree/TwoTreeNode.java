package com.beppe.leetcode.tree;

/**
 * 二叉树的节点
 * 包含  节点值   左节点    右节点
 */
public class TwoTreeNode {
    // 节点数据
    public Integer val;

    // 左节点
    public TwoTreeNode left;

    // 右节点
    public TwoTreeNode right;

    public TwoTreeNode() {
    }

    public TwoTreeNode(Integer val, TwoTreeNode left, TwoTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TwoTreeNode getLeft() {
        return left;
    }

    public void setLeft(TwoTreeNode left) {
        this.left = left;
    }

    public TwoTreeNode getRight() {
        return right;
    }

    public void setRight(TwoTreeNode right) {
        this.right = right;
    }
}
