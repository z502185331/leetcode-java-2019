/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (33.94%)
 * Total Accepted:    132.4K
 * Total Submissions: 374.7K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 *
 * Example:
 *
 *
 * Input:
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 *
 * Output: 6
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution {
     public int countNodes(TreeNode root) {
         int leftHeight = getLeftHeight(root);
         int rightHeight = getRightHeight(root);
         if (leftHeight == rightHeight) {
             return (int) Math.pow(2, leftHeight) - 1;
         }

         return 1 + countNodes(root.left) + countNodes(root.right);
     }

     private int getLeftHeight(TreeNode root) {
         if (root == null) {
             return 0;
         }

         return getLeftHeight(root.left) + 1;
     }

     private int getRightHeight(TreeNode root) {
         if (root == null) {
             return 0;
         }

         return getRightHeight(root.right) + 1;
     }
 }
