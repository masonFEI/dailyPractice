/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * LowestCommonAncestor
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-28 18:50
 */
public class LowestCommonAncestor {


    public static TreeNode resNode;


//    root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

//        TreeNode p = new TreeNode(2);
//        TreeNode q = new TreeNode(8);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);


        TreeNode res = lowestCommonAncestor(root, p, q);

        System.out.println(res.val);
    }


    //    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }


}