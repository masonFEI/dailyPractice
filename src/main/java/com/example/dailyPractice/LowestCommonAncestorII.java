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


    public TreeNode resNode;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backSort(root, p, q);
        return resNode;
    }

    public int backSort(TreeNode root, TreeNode p, TreeNode q) {
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


        if ((leftRes == 1 && rightRes == 2) || (leftRes == 1 && root.val == q.val) || (rightRes == 2 && root.val == p.val)) {
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