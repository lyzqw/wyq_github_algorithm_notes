package com.company.tree;


import com.sun.tools.javac.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大深度
 * @author liuyuzhe
 */
public class TreeDepth {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(maxDepth2(treeNode));
    }



    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Stack<String> s = new Stack();
    //s.push()
    //s.pop() 后进先出
    public static int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.fst;
            Integer current_depth = current.snd;
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair<>(root.left, current_depth+1));
                stack.add(new Pair<>(root.right, current_depth+1));
            }
        }
        return depth;
    }


}
