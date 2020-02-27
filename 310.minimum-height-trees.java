/*
* @lc app=leetcode id=310 lang=java
*
* [310] Minimum Height Trees
*
* https://leetcode.com/problems/minimum-height-trees/description/
*
* algorithms
* Medium (30.60%)
* Total Accepted:    83K
* Total Submissions: 264.1K
* Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
*
* For an undirected graph with tree characteristics, we can choose any node as
* the root. The result graph is then a rooted tree. Among all possible rooted
* trees, those with minimum height are called minimum height trees (MHTs).
* Given such a graph, write a function to find all the MHTs and return a list
* of their root labels.
*
* Format
* The graph contains n nodes which are labeled from 0 to n - 1. You will be
* given the number n and a list of undirected edges (each edge is a pair of
* labels).
*
* You can assume that no duplicate edges will appear in edges. Since all edges
* are undirected, [0, 1] is the same as [1, 0] and thus will not appear
* together in edges.
*
* Example 1 :
*
*
* Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
*
* ⁠       0
* ⁠       |
* ⁠       1
* ⁠      / \
* ⁠     2   3
*
* Output: [1]
*
*
* Example 2 :
*
*
* Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
*
* ⁠    0  1  2
* ⁠     \ | /
* ⁠       3
* ⁠       |
* ⁠       4
* ⁠       |
* ⁠       5
*
* Output: [3, 4]
*
* Note:
*
*
* According to the definition of tree on Wikipedia: “a tree is an undirected
* graph in which any two vertices are connected by exactly one path. In other
* words, any connected graph without simple cycles is a tree.”
* The height of a rooted tree is the number of edges on the longest downward
* path between the root and a leaf.
*
*
*/
class Solution {
   public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       if (n == 1) {
           return Collections.singletonList(0);
       }

       List<Integer>[] graph = new List[n];
       for (int i = 0; i < n; i++) {
           graph[i] = new LinkedList<>();
       }

       // Build the graph
       for (int[] edge : edges) {
           graph[edge[0]].add(edge[1]);
           graph[edge[1]].add(edge[0]);
       }

       // Find out all the leaves
       List<Integer> leaves = new ArrayList<>();
       for (int i = 0; i < n; i++) {
           if (graph[i].size() == 1) {
               leaves.add(i);
           }
       }

       // Traverse from the leaves until we only have 2 or less nodes left
       int remainedNode = n;
       while (remainedNode > 2) {
           remainedNode -= leaves.size();

           List<Integer> newLeaves = new ArrayList<>();
           for (int leaf : leaves) {
               // There must be only on neighbor of leave node
               int neighbor = graph[leaf].get(0);
               graph[neighbor].remove(Integer.valueOf(leaf));
               if (graph[neighbor].size() == 1) {
                   newLeaves.add(neighbor);
               }
           }

           leaves = newLeaves;
       }

       return leaves;
   }
}