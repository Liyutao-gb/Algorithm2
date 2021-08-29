package com.liyutao.binarytree;

/**
 * @Author liyutao
 * @Date 2021/8/29 19:51
 * @Description
 *
 * 另一棵树的子树。   类似于相等树的判断
 * 输入：s			输入 t：
 *      3				    4
 *     / \				  /  \
 *    4   5		         1    2
 *   / \
 *  1   2
 *
 * 另一棵树的子结构。
 *
 *
 */
public class SubTree {

    public static void main(String[] args) {

    }

    //子树
    public boolean isSubTree(TreeNode root, TreeNode subTree) {
        if (root == null || subTree == null)
            return false;

        return isSameTree(root, subTree) || isSubTree(root.left, subTree) || isSubTree(root.right, subTree);
    }

    public boolean isSameTree(TreeNode root, TreeNode subTree) {
        if (root == null && subTree == null)
            return true;
        if (root == null || subTree == null)
            return false;
        if (!root.val.equals(subTree.val))
            return false;
        return isSameTree(root.left, subTree.left) && isSameTree(root.right, subTree.right);
    }


    //子结构
    public boolean isSubStructure(TreeNode root, TreeNode subStructure) {
        if (root == null || subStructure == null)
            return false;

        return isSubStructure(root, subStructure) || isSameStructure(root.left, subStructure) || isSameStructure(root.right, subStructure);
    }

    public boolean isSameStructure(TreeNode root, TreeNode subStructure) {
        if (subStructure == null)
            return true;
        if (root == null)
            return false;
        if (!root.val.equals(subStructure.val))
            return false;

        return isSameStructure(root.left, subStructure.left) && isSameStructure(root.right, subStructure.right);
    }


}
