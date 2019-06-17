/*
 * @lc app=leetcode id=813 lang=java
 *
 * [813] Largest Sum of Averages
 *
 * https://leetcode.com/problems/largest-sum-of-averages/description/
 *
 * algorithms
 * Medium (45.30%)
 * Total Accepted:    13.4K
 * Total Submissions: 29.6K
 * Testcase Example:  '[9,1,2,3,9]\n3'
 *
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest
 * score we can achieve?
 *
 * Note that our partition must use every number in A, and that scores are not
 * necessarily integers.
 *
 *
 * Example:
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9
 * + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 *
 *
 */
 class Solution {
     public double largestSumOfAverages(int[] A, int K) {
         int[] prefixSum = new int[A.length + 1];
         double[][] dp = new double[A.length + 1][K + 1];

         int sum = 0;
         for (int i = 0; i < A.length; i++) {
             sum += A[i];
             prefixSum[i + 1] = sum;
         }

         return findMaxSum(prefixSum, 1, K, dp);
     }

     private double findMaxSum(int[] prefixSum, int cur, int K, double[][] dp) {
         // When there is not enough numbers to be split, return 0
         if (cur == prefixSum.length - 1 && K > 1) {
             return 0;
         }

         // Return the saved value if the same arguments have been run
         if (dp[cur][K] != 0.0) {
             return dp[cur][K];
         }

         // When there is only 1 split left, sum the rest array
         if (K == 1) {
             return (double) (prefixSum[prefixSum.length - 1] - prefixSum[cur - 1]) / (prefixSum.length - cur);
         }

         double max = 0.0;
         for (int i = cur; i < prefixSum.length - 1; i++) {
             double candidate = (double) (prefixSum[i] - prefixSum[cur - 1]) / (i - cur + 1) + findMaxSum(prefixSum, i + 1, K - 1, dp);
             max = Math.max(max, candidate);
         }

         dp[cur][K] = max;
         return max;
     }
 }
