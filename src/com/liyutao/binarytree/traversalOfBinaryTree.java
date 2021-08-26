package com.liyutao.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author liyutao
 * @Date 2021/8/26 7:53
 * @Description 二叉树、N插树、完全二叉树、平衡树、红黑树、
 * 名词：根节点、兄弟节点、公共节点、
 *      UNIX文件系统一种典型的树的数据结构
 * 树的遍历，前序遍历、中序遍历、后序遍历(循环、递归)
 * 二叉树最坏的情况下是链表结构
 *      二叉树有很多与搜索无关的重要应用。
 *
 * 表达式树：
 *      表达式的树叶是操作数。其他的节点为操作符。
 *      后序遍历构造一颗新的树。
 *          （1）如果符号是操作数，那么就建立一个单节点树并将他推入栈中；
 *          （2）如果符号是操作符，那么就从栈中弹出两棵树T1和T2并形成一颗新的树。
 *
 */
public class traversalOfBinaryTree {

    public static void main(String[] args) {


    }


    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null)
            return;

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur =  root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    //中序遍历
    public void inorder(TreeNode root) {
        if (root == null)
            return;

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right != null) {
                stack1.push(pop.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }

    public void recursionOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        recursionOrder(root.left);
        System.out.println(root.val);
        recursionOrder(root.right);

    }


}
