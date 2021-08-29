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
 *  B+树：树深：logm N
 *      性质：1.数据项存储在树叶上
 *           2.非叶子节点存储M-1个关键字；
 *           3.树的根或者是树叶，儿子数在2和M之间。
 *           4.除根外，所有非树叶节点的儿子数在M/2和M之间；
 *           5.所有的树叶都在相同的深度上并由L/2和L之间个数据项。
 *
 *   叶分裂：多次磁盘IO。
 *      1.如果树叶节点没有满员，插入到叶子结点；
 *      2.如果插入后叶子节点满员，则分裂，并修改父节点
 *          （1）如果父节点没有满员，修改父节点（添加一个值）；
 *          （2）如果父节点满员（父节点分裂），找父节点的父节点（修改值）；分裂两次
 *      3.删除节点，可以在相邻节点领养
 *
 */
public class NTree {

    public static void main(String[] args) {

    }

    //前序遍历 循环
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

    //前序遍历 递归
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

    //后序遍历 循环 （根右左 放入一个集合 最后逆向取数据）
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

    //后序遍历 递归版
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
