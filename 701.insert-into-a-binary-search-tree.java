/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
 *
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (76.64%)
 * Total Accepted:    84.5K
 * Total Submissions: 107.4K
 * Testcase Example:  '[4,2,7,1,3]\n5'
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted
 * into the tree, insert the value into the BST. Return the root node of the
 * BST after the insertion. It is guaranteed that the new value does not exist
 * in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as
 * the tree remains a BST after insertion. You can return any of them.
 *
 * For example, 
 *
 *
 * Given the tree:
 * ⁠       4
 * ⁠      / \
 * ⁠     2   7
 * ⁠    / \
 * ⁠   1   3
 * And the value to insert: 5
 *
 *
 * You can return this binary search tree:
 *
 *
 * ⁠        4
 * ⁠      /   \
 * ⁠     2     7
 * ⁠    / \   /
 * ⁠   1   3 5
 *
 *
 * This tree is also valid:
 *
 *
 * ⁠        5
 * ⁠      /   \
 * ⁠     2     7
 * ⁠    / \
 * ⁠   1   3
 * ⁠        \
 * ⁠         4
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

     /** Rebuild the tree */
     public TreeNode insertIntoBST1(TreeNode root, int val) {
         List<Integer> inorder = new ArrayList<>();
         traverse(root, val, inorder);

         if (inorder.get(0) > val) {
             inorder.add(0, val);
         }

         if (inorder.get(inorder.size() - 1) < val) {
             inorder.add(val);
         }

         for (int i = 0; i < inorder.size() - 1; i++) {
             if (inorder.get(i) < val && inorder.get(i + 1) > val) {
                 inorder.add(i + 1, val);
             }
         }

         return buildTree(inorder, 0, inorder.size() - 1);
     }

     private TreeNode buildTree(List<Integer> inorder, int start, int end) {
         if (start > end) {
             return null;
         }

         int mid = start + (end - start) / 2;

         TreeNode node = new TreeNode(inorder.get(mid));
         node.left = buildTree(inorder, start, mid - 1);
         node.right = buildTree(inorder, mid + 1, end);
         return node;
     }

     private void traverse(TreeNode root, int val, List<Integer> inorder) {
         if (root == null) {
             return;
         }

         traverse(root.left, val, inorder);
         inorder.add(root.val);
         traverse(root.right, val, inorder);
     }

     public TreeNode insertIntoBST(TreeNode root, int val) {
         if (root == null) {
             return new TreeNode(val);
         }

         if (root.val > val) {
             root.left = insertIntoBST(root.left, val);
         } else {
             root.right = insertIntoBST(root.right, val);
         }

         return root;
     }
 }
