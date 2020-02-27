/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (61.54%)
 * Total Accepted:    166.9K
 * Total Submissions: 265.7K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e.,
 * one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter
 * of the island.
 *
 *
 *
 * Example:
 *
 *
 * Input:
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 *
 *
 *
 *
 */
 class Solution {

     static final int[][] DIRS = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};

     public int islandPerimeter(int[][] grid) {
         int height = grid.length;
         int width = grid[0].length;

         for (int i = 0; i < height; i++) {
             for (int j = 0; j < width; j++) {
                 if (grid[i][j] == 1) {
                     return findPerimeter(grid, i, j, new boolean[height][width]);
                 }
             }
         }

         return 0;
     }

     private int findPerimeter(int[][] grid, int x, int y, boolean[][] visited) {
         if (visited[x][y] || grid[x][y] == 0) {
             return 0;
         }

         visited[x][y] = true;

         int borderCount = 0;
         for (int[] dir : DIRS) {
             int newX = x + dir[0];
             int newY = y + dir[1];

             if (newX < 0 || newX >= grid.length ||
                 newY < 0 || newY >= grid[0].length ||
                 grid[newX][newY] == 0) {
                 borderCount++;
             } else {
                 borderCount += findPerimeter(grid, newX, newY, visited);
             }
         }

         return borderCount;
     }
 }
