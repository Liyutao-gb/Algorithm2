package com.liyutao.binarytree;

import java.util.*;

/**
 * @Author liyutao
 * @Date 2021/8/28 13:41
 * @Description B树、N叉树
 *
 *  N叉树和二叉树区别之处在于N叉树是根节点指向子节点的List<children>集合
 *  N叉树的前序遍历 和 后序遍历（递归和循环）、层序遍历
 *
 */
public class NTree {

    public static void main(String[] args) {

    }

    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0 ; i--) {
                stack.add(node.children.get(i));
            }
        }
        return list;
    }

    public List<Integer> preOrderRecursion(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        preOrderHelper(root, list);
        return list;
    }

    public void preOrderHelper(Node root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preOrderHelper(root.children.get(i), list);
        }
    }

    public List<Integer> postOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(0, node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }

        return list;
    }

    public List<Integer> postOrderRecursion(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        postOrderHelper(root, list);
        return list;
    }

    public void postOrderHelper(Node root, List<Integer> list) {
        if (root == null)
            return;

        for (int i = 0; i < root.children.size(); i++) {
            postOrderHelper(root.children.get(i), list);
        }
        list.add(root.val);
    }

}
