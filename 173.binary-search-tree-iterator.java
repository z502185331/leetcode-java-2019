/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (49.83%)
 * Total Accepted:    265.2K
 * Total Submissions: 498.4K
 * Testcase Example:  '["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]\n[[[7,3,15,null,null,9,20]],[null],[null],[null],[null],[null],[null],[null],[null],[null]]'
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 *
 *
 *
 * Example:
 *
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 *
 *
 * Note:
 *
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be
 * at least a next smallest number in the BST when next() is called.
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
 class BSTIterator1 {

     List<Integer> preorder = new LinkedList<>();
     Iterator<Integer> it;

     public BSTIterator1(TreeNode root) {
         traverse(root);
         it = preorder.iterator();
     }

     /** @return the next smallest number */
     public int next() {
         return it.next();
     }

     /** @return whether we have a next smallest number */
     public boolean hasNext() {
         return it.hasNext();
     }

     private void traverse(TreeNode root) {
         if (root == null) {
             return;
         }

         traverse(root.left);
         preorder.add(root.val);
         traverse(root.right);
     }
 }

 class BSTIterator {

     private Stack<TreeNode> stack;

     public BSTIterator(TreeNode root) {
         stack = new Stack<>();
         collectInOrder(root);
     }

     /** @return the next smallest number */
     public int next() {
         TreeNode node = stack.pop();

         if (node.right != null) {
             collectInOrder(node.right);
         }

         return node.val;
     }

     /** @return whether we have a next smallest number */
     public boolean hasNext() {
         return !stack.isEmpty();
     }

     private void collectInOrder(TreeNode node) {
         while (node != null) {
             stack.push(node);
             node = node.left;
         }
     }
 }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
