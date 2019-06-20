/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (29.34%)
 * Total Accepted:    215.1K
 * Total Submissions: 731.9K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 *
 * Example 2:
 *
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
 class Solution {
     /** Timeout
     public int maxProduct(int[] nums) {
         if (nums.length == 0) {
             return 0;
         }

         int n = nums.length;
         int[][] dp = new int[n][n];

         int max = Integer.MIN_VALUE;
         for (int i = 0; i < n; i++) {
             for (int j = i; j < n; j++) {
                 if (nums[j] == 0) {
                     break;
                 }

                 if (i == j) {
                     dp[i][j] = nums[i];
                 } else {
                     dp[i][j] = dp[i][j - 1] * nums[j];
                 }

                 max = Math.max(dp[i][j], max);
             }
         }

         return max;
     } */

     public int maxProduct(int[] nums) {
         if (nums.length == 0) {
             return 0;
         }

         int res = nums[0];
         int max = nums[0];
         int min = nums[0];

         for (int i = 1; i < nums.length; i++) {

             if (nums[i] >= 0) {
                 max = max > 0 ? max * nums[i] : nums[i];
                 min = min <= 0 ? min * nums[i] : nums[i];
             } else {
                 int tmp = max;
                 max = min <= 0 ? min * nums[i] : nums[i];
                 min = tmp > 0 ? tmp * nums[i] : nums[i];
             }

             res = Math.max(res, max);
         }

         return res;
     }
 }
