/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 *
 * https://leetcode.com/problems/uncrossed-lines/description/
 *
 * algorithms
 * Medium (51.91%)
 * Total Accepted:    10.9K
 * Total Submissions: 20.4K
 * Testcase Example:  '[1,4,2]\n[1,2,4]'
 *
 * We write the integers of A and B (in the order they are given) on two
 * separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers
 * A[i] and B[j] such that:
 *
 *
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal)
 * line.
 *
 *
 * Note that a connecting lines cannot intersect even at the endpoints: each
 * number can only belong to one connecting line.
 *
 * Return the maximum number of connecting lines we can draw in this way.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4
 * will intersect the line from A[2]=2 to B[1]=2.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 *
 *
 *
 * Example 3:
 *
 *
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 *
 *
 */
 class Solution {

     public int maxUncrossedLines(int[] A, int[] B) {
         if (A.length == 0 || B.length == 0) {
             return 0;
         }

         int alen = A.length;
         int blen = B.length;
         int[][] dp = new int[alen + 1][blen + 1];

         for (int i = 1; i < alen + 1; i++) {
             for (int j = 1; j < blen + 1; j++) {
                 if (A[i - 1] == B[j - 1]) {
                     dp[i][j] = dp[i - 1][j - 1] + 1;
                 } else {
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                 }
             }
         }

         return dp[alen][blen];
     }

     // 超时
     public int maxUncrossedLines1(int[] A, int[] B) {
         if (A.length == 0 || B.length == 0) {
             return 0;
         }

         Map<Integer, Set<Integer>> bMap = new HashMap<>();
         for (int i = 0; i < A.length; i++) {
             if (!bMap.containsKey(A[i])) {
                 bMap.put(A[i], new HashSet<>());
             }
         }

         for (int i = 0; i < B.length; i++) {
             if (!bMap.containsKey(B[i])) {
                 continue;
             }

             bMap.get(B[i]).add(i);
         }

         return traverse(A, bMap, 0, new LinkedList<>());
     }

     private int traverse(int[] A, Map<Integer, Set<Integer>> bMap, int start, List<int[]> lines) {
         if (start == A.length) {
             return 0;
         }

         int num = A[start];

         // starts with the situation no line is connected
         int maxLines = traverse(A, bMap, start + 1, lines);
         boolean connected = false;
         for (int end : bMap.get(num)) {
             if (isCrossing(start, end, lines)) {
                 continue;
             }

             lines.add(new int[]{start, end});
             int res = traverse(A, bMap, start + 1, lines);
             if (res >= maxLines) {
                 connected = true;
                 maxLines = res;
             }
             lines.remove(lines.size() - 1);
         }

         return connected ? maxLines + 1 : maxLines;
     }

     private boolean isCrossing(int start, int end, List<int[]> lines) {
         for (int[] line : lines) {
             if ((line[0] > start && line[1] < end) ||
                     (line[0] < start && line[1] > end) ||
                     line[0] == start ||
                     line[1] == end) {

                 return true;
             }
         }

         return false;
     }
 }
