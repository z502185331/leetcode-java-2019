/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (63.79%)
 * Total Accepted:    71.2K
 * Total Submissions: 109.9K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree.  From left to right order, the
 * values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 *
 * Both of the given trees will have between 1 and 100 nodes.
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
     public boolean leafSimilar(TreeNode root1, TreeNode root2) {
         List<Integer> leaves1 = new ArrayList<>();
         List<Integer> leaves2 = new ArrayList<>();

         collectLeafNodes(root1, leaves1);
         collectLeafNodes(root2, leaves2);

         return leaves1.equals(leaves2);
     }

     private void collectLeafNodes(TreeNode root, List<Integer> leaves) {
         if (root == null) {
             return;
         }

         collectLeafNodes(root.left, leaves);

         if (root.left == null && root.right == null) {
             leaves.add(root.val);
             return;
         }

         collectLeafNodes(root.right, leaves);
     }
 }
