package com.liyutao.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author liyutao
 * @Date 2021/8/29 19:34
 * @Description
 *
 * 二叉树的路径：判断有没有一个路径上的值等于sum
 *
 */
public class PathOfTree {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //递归版
    public List<Integer> hasPathSumRecursion(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();

        Stack<Integer> list = new Stack<>();
        hasPathHelper(root, list, sum);
        return list;
    }

    public void hasPathHelper(TreeNode root, Stack<Integer> list, int sum) {
        if (root == null)
            return;

        list.push(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null)
            //打印list
            return;
        hasPathHelper(root.left, list, sum);
        hasPathHelper(root.right, list, sum);
        list.pop();
    }

}
