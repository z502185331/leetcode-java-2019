/*
 * @lc app=leetcode id=1129 lang=java
 *
 * [1129] Shortest Path with Alternating Colors
 *
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/description/
 *
 * algorithms
 * Medium (36.03%)
 * Total Accepted:    9.1K
 * Total Submissions: 24K
 * Testcase Example:  '3\n[[0,1],[1,2]]\n[]'
 *
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this
 * graph, each edge is either red or blue, and there could be self-edges or
 * parallel edges.
 *
 * Each [i, j] in red_edges denotes a red directed edge from node i to node j.
 * Similarly, each [i, j] in blue_edges denotes a blue directed edge from node
 * i to node j.
 *
 * Return an array answer of length n, where each answer[X] is the length of
 * the shortest path from node 0 to node X such that the edge colors alternate
 * along the path (or -1 if such a path doesn't exist).
 *
 *
 * Example 1:
 * Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * Output: [0,1,-1]
 * Example 2:
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * Output: [0,1,-1]
 * Example 3:
 * Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * Output: [0,-1,-1]
 * Example 4:
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * Output: [0,1,2]
 * Example 5:
 * Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * Output: [0,1,1]
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 *
 */
 class Solution {
     public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
         List<Integer>[] redGraph = new List[n];
         List<Integer>[] blueGraph = new List[n];
         int[] paths = new int[n];

         // Build the red and blue graphs
         for (int i = 0; i < n; i++) {
             redGraph[i] = new LinkedList<>();
             blueGraph[i] = new LinkedList<>();
             paths[i] = -1;
         }
         for (int[] edge : red_edges) {
             redGraph[edge[0]].add(edge[1]);
         }

         for (int[] edge : blue_edges) {
             blueGraph[edge[0]].add(edge[1]);
         }

         bsf(n, redGraph, blueGraph, true, paths);
         bsf(n, redGraph, blueGraph, false, paths);

         return paths;
     }

     private void bsf(int n, List<Integer>[] redGraph, List<Integer>[] blueGraph, boolean prevRed, int[] path) {
         boolean[] blueVisited = new boolean[n];
         boolean[] redVisited = new boolean[n];

         Queue<Integer> queue = new LinkedList<>();
         queue.offer(0);

         int level = 0;
         while (!queue.isEmpty()) {
             int size = queue.size();
             for (int i = 0; i < size; i++) {

                 int now = queue.poll();
                 boolean[] visited = prevRed ? redVisited : blueVisited;

                 if (visited[now]) {
                     continue;
                 }

                 visited[now] = true;
                 if (path[now] == -1 || path[now] > level) {
                     path[now] = level;
                 }

                 List<Integer> neighbors = prevRed ? blueGraph[now] : redGraph[now];
                 for (int neighbor : neighbors) {
                     queue.offer(neighbor);
                 }
             }

             prevRed = !prevRed;
             level++;
         }
     }
 }
