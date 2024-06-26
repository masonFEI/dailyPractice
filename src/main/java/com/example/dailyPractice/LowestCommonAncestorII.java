/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.example.dailyPractice;

/**
 * LowestCommonAncestorII
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-05-30 19:40
 */
public class LowestCommonAncestorII {


    public static TreeNode resNode;


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);

        lowestCommonAncestor(root, p, q);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else return right;

    }

    public static int backSort(TreeNode root, TreeNode p, TreeNode q) {
        int leftRes = 0;
        int rightRes = 0;
        if (root.left != null) {
            leftRes = backSort(root.left, p, q);
        }
        if (root.right != null) {
            rightRes = backSort(root.right, p, q);
        }

        if (leftRes == 3 || rightRes == 3) {
            return 3;
        }

        if ((leftRes == 1 && rightRes == 2) || (leftRes == 2 && rightRes == 1) || ((leftRes == 1 || rightRes == 1) && root.val == q.val) || ((leftRes == 2 || rightRes == 2) && root.val == p.val)) {
            resNode = root;
            return 3;
        } else {
            if (root.val == p.val || leftRes == 1 || rightRes == 1) {
                return 1;
            }

            if (root.val == q.val || leftRes == 2 || rightRes == 2) {
                return 2;
            }
        }

        return 0;

    }


}