package com.liyutao.binarytree;

/**
 * @Author liyutao
 * @Date 2021/8/28 11:01
 * @Description 平衡树:任意节点的左右子树的深度相差不超过1。
 * 平衡是通过旋转来保持平衡的。
 *
 * 平衡树的验证
 *
 */
public class AVLTree {

    public static void main(String[] args) {

    }

    boolean flag = true;

    public int isAVLTree(TreeNode root) {
        if (root == null)
            return 0;

        int h = isAVLTree(root.left);
        int h2 = isAVLTree(root.right);
        if (Math.abs(h - h2) > 1) {
            flag = false;
        }
        return Math.max(h, h2) + 1;
    }

}
