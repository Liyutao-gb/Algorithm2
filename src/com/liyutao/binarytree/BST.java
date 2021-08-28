package com.liyutao.binarytree;

import java.util.Stack;

/**
 * @Author liyutao
 * @Date 2021/8/26 23:50
 * @Description 二叉查找树 ADT(Abstract Data Type)
 *  二叉查找树要和中序遍历联系。
 *
 * 二叉查找某个值，二叉查找树的验证
 *
 */
public class BST {

    public static void main(String[] args) {

    }

    public TreeNode findVal(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            return findVal(root.left, val);
        } else if (root.val < val) {
            return findVal(root.right, val);
        } else {
            return root;
        }
    }

    public boolean isBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur !=null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val > cur.val) {
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    public boolean isBSTRecursion(TreeNode root, int left, int right) {
        if (root == null)
            return true;
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer left, Integer right) {
        if (root == null)
            return true;

        if (left != null && left >= root.val)
            return false;
        if (right != null && right <= root.val)
            return false;

        //return isBSTRecursion(root.left, root.val, left) && isBSTRecursion(root.right, right, root.val);
        return isBSTRecursion(root.left, left, root.val) && isBSTRecursion(root.right, root.val, right);
    }




}
