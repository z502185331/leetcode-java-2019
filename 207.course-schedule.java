/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (38.79%)
 * Total Accepted:    323.7K
 * Total Submissions: 792.8K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 *
 * Example 1:
 *
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 *
 *
 * Note:
 *
 *
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 *
 *
 */
 class Solution {
     /** DFS */
     public boolean canFinish1(int numCourses, int[][] prerequisites) {

         if (numCourses <= 1) {
             return true;
         }

         // Build the graph
         Map<Integer, List<Integer>> graph = new HashMap<>();
         for (int[] r : prerequisites) {
             if (!graph.containsKey(r[0])) {
                 graph.put(r[0], new ArrayList<>());
             }

             graph.get(r[0]).add(r[1]);
         }

         // Traverse the graph and figure out if cycle exists
         Set<Integer> visited = new HashSet<>();
         for (int i = 0; i < numCourses; i++) {
             if (hasCycle(graph, i, visited, new HashSet<>())) {
                 return false;
             }
         }

         return true;
     }

     private boolean hasCycle(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, Set<Integer> path) {

         if (path.contains(node)) {
             return true;
         }

         if (visited.contains(node) || !graph.containsKey(node)) {
             return false;
         }

         visited.add(node);
         path.add(node);

         for (int neighbor : graph.get(node)) {
             if (hasCycle(graph, neighbor, visited, path)) {
                 return true;
             }
         }

         path.remove(node);
         return false;
     }

     // 拓扑排序
     public boolean canFinish(int numCourses, int[][] prerequisites) {
         int[] incomingEdges = new int[numCourses];
         List<Integer>[] edges = new List[numCourses];

         for (int i = 0; i < numCourses; i++) {
             edges[i] = new LinkedList<>();
         }

         // Build the graph
         for (int[] prerequisite : prerequisites) {
             incomingEdges[prerequisite[0]]++;
             edges[prerequisite[1]].add(prerequisite[0]);
         }

         // Try to find all the node with no incoming edge
         Queue<Integer> queue = new LinkedList<>();
         for (int i = 0; i < numCourses; i++) {
             if (incomingEdges[i] == 0) {
                 queue.offer(i);
             }
         }

         // Do the topological sorting
         int edgeCount = prerequisites.length;
         while (!queue.isEmpty()) {
             int course = queue.poll();

             // Remove all the edges
             for (int target : edges[course]) {
                 if (--incomingEdges[target] == 0) {
                     queue.offer(target);
                 }
                 edgeCount--;
             }
         }

         return edgeCount == 0;
     }
 }
