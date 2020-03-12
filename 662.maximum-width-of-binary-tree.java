/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (39.51%)
 * Total Accepted:    48.6K
 * Total Submissions: 122.6K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given a binary tree, write a function to get the maximum width of the given
 * tree. The width of a tree is the maximum width among all levels. The binary
 * tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 *
 * Input:
 *
 * ⁠          1
 * ⁠        /   \
 * ⁠       3     2
 * ⁠      / \     \
 * ⁠     5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4
 * (5,3,null,9).
 *
 *
 * Example 2:
 *
 *
 * Input:
 *
 * ⁠         1
 * ⁠        /
 * ⁠       3
 * ⁠      / \
 * ⁠     5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2
 * (5,3).
 *
 *
 * Example 3:
 *
 *
 * Input:
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /
 * ⁠     5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length
 * 2 (3,2).
 *
 *
 * Example 4:
 *
 *
 * Input:
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /     \
 * ⁠     5       9
 * ⁠    /         \
 * ⁠   6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8
 * (6,null,null,null,null,null,null,7).
 *
 *
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
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
     public int widthOfBinaryTree(TreeNode root) {
         TreeNode curr = root;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(curr);
         Map<TreeNode, Integer> posDic = new HashMap<>();
         int max = Integer.MIN_VALUE;
         while(!queue.isEmpty()) {
             int size = queue.size();
             int left = -1;
             for(int i = 0; i < size; i++) {
                 TreeNode n = queue.poll();
                 if(i == 0) left = posDic.getOrDefault(n, 1); //first polled node from queue is the left side of the tree in same level
                 if(n.left != null) {
                     queue.offer(n.left);
                     posDic.put(n.left, posDic.getOrDefault(n, 1) * 2);
                 }
                 if(n.right != null) {
                     queue.offer(n.right);
                     posDic.put(n.right, posDic.getOrDefault(n, 1) * 2 + 1);
                 }
                 max = Math.max(max, posDic.getOrDefault(n, 1) - left + 1);
             }
         }
         return max;
     }
 }
