/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (43.55%)
 * Total Accepted:    267.9K
 * Total Submissions: 603.3K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 *
 *
 * The flattened tree should look like:
 *
 *
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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

     // With queue
     public void flatten1(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();

         queueNode(root, queue);

         while (!queue.isEmpty()) {
             TreeNode cur = queue.poll();

             cur.left = null;
             cur.right = queue.peek();
         }
     }

     private void queueNode(TreeNode cur, Queue<TreeNode> queue) {
         if (cur == null) {
             return;
         }

         queue.offer(cur);
         queueNode(cur.left, queue);
         queueNode(cur.right, queue);
     }

     // In place
     private TreeNode prevNode;
     public void flatten(TreeNode root) {
         if (root == null) {
             return;
         }

         TreeNode rightChild = root.right;

         if (prevNode != null) {
             prevNode.right = root;
         }

         prevNode = root;
         flatten(root.left);
         flatten(rightChild);

         root.left = null;
     }
 }
