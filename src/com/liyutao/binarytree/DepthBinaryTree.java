package com.liyutao.binarytree;

/**
 * @Author liyutao
 * @Date 2021/8/28 20:02
 * @Description
 *
 * 二叉树的最大深度
 */
public class DepthBinaryTree {

    public static void main(String[] args) {

    }

    // 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
