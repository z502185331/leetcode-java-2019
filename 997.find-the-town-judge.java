/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 *
 * https://leetcode.com/problems/find-the-town-judge/description/
 *
 * algorithms
 * Easy (49.41%)
 * Total Accepted:    38.7K
 * Total Submissions: 78.2K
 * Testcase Example:  '2\n[[1,2]]'
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that
 * one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 *
 *
 * You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town
 * judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 *
 *
 * Example 2:
 *
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 *
 *
 * Example 3:
 *
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 *
 *
 * Example 4:
 *
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 *
 *
 * Example 5:
 *
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
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
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 *
 */
 class Solution {
     /**
     public int findJudge(int N, int[][] trust) {
         if (N == 1) {
             return 1;
         }

         Map<Integer, Set<Integer>> trusting = new HashMap<>();
         Map<Integer, Set<Integer>> trusted = new HashMap<>();

         for (int[] conn : trust) {
             if (!trusting.containsKey(conn[0])) {
                 trusting.put(conn[0], new HashSet<>());
             }

             if (!trusted.containsKey(conn[1])) {
                 trusted.put(conn[1], new HashSet<>());
             }

             trusting.get(conn[0]).add(conn[1]);
             trusted.get(conn[1]).add(conn[0]);
         }

         for (int i = 1; i <= N; i++) {
             if (trusting.get(i) != null) {
                 continue;
             }

             if (trusted.get(i) == null || trusted.get(i).size() != N - 1) {
                 continue;
             }

             return i;
         }

         return -1;
     }
     */

     public int findJudge(int N, int[][] trust) {
         int[] adjOuts = new int[N + 1];
         int[] adjIns = new int[N + 1];

         for (int[] conn : trust) {
             adjOuts[conn[0]]++;
             adjIns[conn[1]]++;
         }

         for (int i = 1; i <= N; i++) {
             if (adjOuts[i] == 0 && adjIns[i] == N - 1) {
                 return i;
             }
         }

         return -1;
     }

 }
