/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.56%)
 * Total Accepted:    250.7K
 * Total Submissions: 809.8K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2:
 *
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
 class Solution {
     public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> res = new ArrayList<>();

         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
             return res;
         }

         int offset = 0;
         int n = matrix.length;
         int m = matrix[0].length;

         while (offset <= (n - 1) / 2 && offset <= (m - 1) / 2) {
             // iterate the top row
             for (int i = offset; i < m - offset; i++) {
                 res.add(matrix[offset][i]);
             }

             // iterate the right column
             for (int i = offset + 1; i < n - offset; i++) {
                 res.add(matrix[i][m - offset - 1]);
             }

             // iterate the bottom row
             if (n - offset - 1 != offset) {
                 for (int i = m - offset - 2; i >= offset; i--) {
                     res.add(matrix[n - offset - 1][i]);
                 }
             }

             if (offset != m - offset - 1) {
                 for (int i = n - offset - 2; i > offset; i--) {
                     res.add(matrix[i][offset]);
                 }
             }

             offset++;
         }

         return res;
     }
 }
