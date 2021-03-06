package com.liyutao.binarytree;

import java.util.List;

/**
 * @Author liyutao
 * @Date 2021/8/28 13:44
 * @Description
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}