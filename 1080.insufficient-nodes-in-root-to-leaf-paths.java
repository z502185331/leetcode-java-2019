/*
 * @lc app=leetcode id=1080 lang=java
 *
 * [1080] Insufficient Nodes in Root to Leaf Paths
 *
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/description/
 *
 * algorithms
 * Medium (42.96%)
 * Total Accepted:    9.8K
 * Total Submissions: 20.8K
 * Testcase Example:  '[1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]\n1'
 *
 * Given the root of a binary tree, consider all root to leaf paths: paths from
 * the root to any leaf.  (A leaf is a node with no children.)
 *
 * A node is insufficient if every such root to leaf path intersecting this
 * node has sum strictly less than limit.
 *
 * Delete all insufficient nodes simultaneously, and return the root of the
 * resulting binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 *
 * Output: [1,2,3,4,null,null,7,8,9,null,14]
 *
 *
 *
 * Example 2:
 *
 *
 *
 * Input: root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 *
 * Output: [5,4,8,11,null,17,4,7,null,null,null,5]
 *
 *
 *
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,-3,-5,null,4,null], limit = -1
 *
 * Output: [1,null,-3,4]
 *
 *
 *
 *
 * Note:
 *
 *
 * The given tree will have between 1 and 5000 nodes.
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 *
 *
 *
 *
 *
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

     // If left/right node returns all sums less than limit, break the connection
     public TreeNode sufficientSubset(TreeNode root, int limit) {
         TreeNode preRoot = new TreeNode(0);
         preRoot.left = root;
         preRoot.right = new TreeNode(Integer.MAX_VALUE);

         traverse(preRoot, 0, limit);
         return preRoot.left;
     }

     private boolean traverse(TreeNode root, int sum, int limit) {
         if (root == null) {
             return true;
         }

         sum += root.val;

         if (root.left == null && root.right == null) {
             return sum < limit;
         }

         boolean leftCheck = traverse(root.left, sum, limit);
         boolean rightCheck = traverse(root.right, sum, limit);

         if (leftCheck && rightCheck) {
             return true;
         } else if (leftCheck) {
             root.left = null;
         } else if (rightCheck) {
             root.right = null;
         }

         return false;
     }
 }
