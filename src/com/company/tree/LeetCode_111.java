package com.company.tree;

import java.util.LinkedList;

import javafx.util.Pair;

/**
 * 二叉树最小深度
 *
 * @author liuyuzhe
 */
public class LeetCode_111 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(minDepth2(treeNode));
        }


    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null)
            return 1;

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        if (root.left == null || root.right == null)
            return leftHeight + rightHeight + 1;

        return Math.min(leftHeight, rightHeight)+1;
    }

    public static int minDepth2(TreeNode root) {
        LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }else {
            stack.add(new Pair<>(root,1));
        }

        int current_depth=0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            current_depth = current.getValue();
            if (root.left == null && root.right==null){
                break;
            }

            if (root.left!=null){
                stack.add(new Pair<>(root.left,current_depth+1));
            }

            if (root.right!=null){
                stack.add(new Pair<>(root.right,current_depth+1));
            }
        }

        return current_depth;
    }


}
