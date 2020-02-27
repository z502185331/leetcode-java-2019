/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (58.33%)
 * Total Accepted:    82.2K
 * Total Submissions: 138.2K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 *
 * Input:
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \
 * ⁠     5   3   9
 *
 * Output: [1, 3, 9]
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
     public List<Integer> largestValues(TreeNode root) {
         List<Integer> maxValues = new ArrayList<>();

         if (root == null) {
             return maxValues;
         }

         Queue<TreeNode> levels = new LinkedList<>();
         levels.offer(root);

         while (!levels.isEmpty()) {
             int size = levels.size();

             int max = Integer.MIN_VALUE;
             for (int i = 0; i < size; i++) {
                 TreeNode node = levels.poll();
                 max = Math.max(max, node.val);

                 if (node.left != null) {
                     levels.offer(node.left);
                 }

                 if (node.right != null) {
                     levels.offer(node.right);
                 }
             }

             maxValues.add(max);
         }

         return maxValues;
     }
 }
