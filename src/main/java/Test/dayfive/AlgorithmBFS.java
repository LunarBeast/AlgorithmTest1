package Test.dayfive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlgorithmBFS {
    /*
    * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    *       3
           / \
          9  20
            /  \
           15   7
    */
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(15, null, null);
        TreeNode node2 = new TreeNode(20, node3, node4);
        TreeNode node1 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, node1, node2);

//        System.out.println(getNodeValue(root).toString());
        System.out.println(getNodeValue1(root).toString());


    }

    public static List<List<Integer>> getNodeValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<List<Integer>> resList = new ArrayList<List<Integer>>();


        if (root == null) {
            resList.add(new ArrayList<Integer>(){});
            return resList;
        }
        queue.offer(root);
        int count = 1;
        int sum = 1;
        boolean flag = true;
        while (flag) {
            ArrayList<Integer> integers = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                if ((root = queue.poll()) != null) {
                    integers.add(root.val);
                    sum--;
                    if (root.left != null) {
                        queue.offer(root.left);
                        sum++;
                    }
                    if (root.right != null) {
                        queue.offer(root.right);
                        sum++;
                    }
                }
            }
            count = sum;
            resList.add(integers);
            if (sum == 0) {
                flag = false;
            }
        }
        return resList;
    }
    public static List<List<Integer>> getNodeValue1(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> integers = new ArrayList<Integer>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                integers.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null)
                    queue.offer(node.right);
            }
            resList.add(integers);
        }
        return resList;
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    /*
    * 问题：
    * 1、while循环判断条件直接判断queue是否为空就可以
    * 2、for循环的判断条件为queue的size
    *
    * 解析：
    * 时间复杂度为O(n)
    * 空间复杂度为O(n)
    * 1、先判断根节点是否为空，为空直接返回 []
    * 2、两层循环，while循环条件队列是否为空
    *              for循环条件为队列的size大小
    * */

    // TODO: 2021/7/30 题2:
    /*
     * 323. 无向图中连通分量的数目
            给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
            示例 1:
            输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
                 0          3
                 |          |
                 1 --- 2    4
            输出: 2
            示例 2:
            输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
                 0           4
                 |           |
                 1 --- 2 --- 3
            输出:  1
            注意:
            你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
     *


     */









}
