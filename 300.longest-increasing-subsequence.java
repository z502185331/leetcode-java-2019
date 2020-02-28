/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (41.20%)
 * Total Accepted:    315.3K
 * Total Submissions: 752.4K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 *
 * Example:
 *
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4.
 *
 * Note:
 *
 *
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 *
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
 class Solution {
     public int lengthOfLIS(int[] nums) {
         if (nums.length == 0) {
             return 0;
         }

         // Define dp[i] is the longest increasing sequences of sublist [0, i]
         int[] dp = new int[nums.length];
         dp[0] = 1;
         int res = 1;

         for (int i = 1; i < nums.length; i++) {
             int max = 0;

             for (int j = 0; j < i; j++) {
                 if (nums[i] <= nums[j]) {
                     continue;
                 }

                 max = Math.max(max, dp[j]);
             }

             dp[i] = max + 1;
             res = Math.max(res, dp[i]);
         }

         return res;
     }
 }
