/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 *
 * https://leetcode.com/problems/shortest-bridge/description/
 *
 * algorithms
 * Medium (44.42%)
 * Total Accepted:    18.8K
 * Total Submissions: 40.8K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * In a given 2D binary array A, there are two islands.  (An island is a
 * 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to
 * form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed
 * that the answer is at least 1.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [[0,1],[1,0]]
 * Output: 1
 *
 *
 *
 * Example 2:
 *
 *
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 *
 *
 * Example 3:
 *
 *
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 *
 *
 *
 *
 *
 *
 *
 */
 class Solution {

     static final int[][] DIRS = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};

     public int shortestBridge(int[][] A) {
         Set<Pair<Integer, Integer>> visited = new HashSet<>();
         List<Set<Pair<Integer, Integer>>> islands = new ArrayList<>();

         for (int i = 0; i < A.length; i++) {
             for (int j = 0; j < A[0].length; j++) {
                 if (A[i][j] == 0 || visited.contains(new Pair<>(i, j))) {
                     continue;
                 }

                 Set<Pair<Integer, Integer>> island = new HashSet<>();
                 collectIsland(A, i, j, visited, island);
                 islands.add(island);
             }
         }

         // Filter the border node
         Set<Pair<Integer, Integer>> starts = islands.get(0);
         Set<Pair<Integer, Integer>> ends = islands.get(1);

         int level = 0;
         visited = new HashSet<>();
         while (!starts.isEmpty() || !ends.isEmpty()) {

             // Always keeps the smaller set at the starts
             if (starts.size() > ends.size()) {
                 Set<Pair<Integer, Integer>> tmp = starts;
                 starts = ends;
                 ends = tmp;
             }

             Set<Pair<Integer, Integer>> tmpSet = new HashSet<>();
             for (Pair<Integer, Integer> node : starts) {
                 for (int[] dir : DIRS) {
                     int newX = node.getKey() + dir[0];
                     int newY = node.getValue() + dir[1];

                     Pair<Integer, Integer> newNode = new Pair<>(newX, newY);

                     if (ends.contains(newNode)) {
                         return level;
                     }

                     if (starts.contains(newNode) || visited.contains(newNode)) {
                         continue;
                     }

                     visited.add(newNode);
                     if (newX < 0 || newX >= A.length ||
                         newY < 0 || newY >= A[0].length) {
                         continue;
                     }

                     tmpSet.add(newNode);
                 }
             }

             starts = tmpSet;
             level++;
         }

         return level;
     }

     private void collectIsland(int[][] A, int x, int y, Set<Pair<Integer, Integer>> visited, Set<Pair<Integer, Integer>> island) {
         if (A[x][y] == 0) {
             return;
         }

         Pair<Integer, Integer> location = new Pair<>(x, y);
         if (visited.contains(location)) {
             return;
         }

         island.add(location);
         visited.add(location);

         for (int[] dir : DIRS) {
             int newX = x + dir[0];
             int newY = y + dir[1];

             if (newX >= 0 && newX < A.length && newY >= 0 && newY < A[0].length) {
                 collectIsland(A, newX, newY, visited, island);
             }
         }
     }
 }
