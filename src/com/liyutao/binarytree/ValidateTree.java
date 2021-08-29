package com.liyutao.binarytree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author liyutao
 * @Date 2021/8/29 16:22
 * @Description
 *
 * 相同的树、对称的树。
 * 完全二叉树：树中所含的n个节点和满二叉树中编号为1至n的节点一一对应。
 * 满二叉树：深度为k且含有2的k次方-1个节点的二叉树。
 *
 * poll():移除头部元素，如果为空，返回null。   peek()：返回队列头部的元素，如果队列为空，返回null。
 * take()：如果队列为空则阻塞调用线程，直到队列不为空然后返回元素。  element():返回队列的头元素，如果队列为空，则抛NoSuchElementException异常。
 *
 * offer():添加一个元素并返回true，如果队列已经满，返回false。   add()：添加一个元素，如果队列已经满，返回IllegalStateException异常。
 * put():添加一个元素并返回true，如果队列已满则阻塞当前线程直到队列有空闲插入。
 *
 */
public class ValidateTree {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(null);
        System.out.println(queue);
    }

    // 相同的树、对称的树
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        //return isSameTree(root1.left, root2.right) && isSameTree(root1.right, root2.left);
    }

    //迭代法
    public boolean isSameTreeRecursion(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }

    //完全二叉树
    public boolean completeBinaryTree(TreeNode root) {
        if (root == null)
            return true;

        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(cur);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                flag = true;
                continue;
            }
            if (flag)
                return false;
            queue.add(root.left);
            queue.add(root.right);
        }
        return true;
    }


}
