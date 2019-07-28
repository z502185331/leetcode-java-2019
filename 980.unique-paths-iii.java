/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 *
 * https://leetcode.com/problems/unique-paths-iii/description/
 *
 * algorithms
 * Hard (71.03%)
 * Total Accepted:    11.2K
 * Total Submissions: 15.7K
 * Testcase Example:  '[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]'
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 *
 *
 * Return the number of 4-directional walks from the starting square to the
 * ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 *
 * Example 2:
 *
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 *
 *
 * Example 3:
 *
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the
 * grid.
 *
 *
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= grid.length * grid[0].length <= 20
 *
 */
 class Solution {

     public int uniquePathsIII(int[][] grid) {
         int m = grid.length;
         int n = grid[0].length;

         int x = 0, y = 0;

         int empty = 1;

         for(int i = 0; i < m; i ++) {
             for(int j = 0; j< n; j++) {
                 if(grid[i][j] == 1) {
                     x = i;
                     y = j;
                 } else if((grid[i][j] == 0)){
                     empty++;
                 }
             }
         }

         return traverse(grid, x, y, empty);
     }

     private int traverse(int[][] grid, int x, int y, int empty) {
         if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
             return 0;
         }

         if (grid[x][y] == 2) {
             return empty == 0 ? 1 : 0;
         }

         int options = 0;
         grid[x][y] = -2;
         empty--;

         options += traverse(grid, x - 1, y, empty);
         options += traverse(grid, x, y + 1, empty);
         options += traverse(grid, x + 1, y, empty);
         options += traverse(grid, x, y - 1, empty);

         empty++;
         grid[x][y] = 0;
         return options;
     }
 }
