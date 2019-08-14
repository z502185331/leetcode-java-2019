/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (55.07%)
 * Total Accepted:    147.3K
 * Total Submissions: 266K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 *
 * Example 1:
 *
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 *
 *
 *
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 *
 */
 class Solution {
     public int findMaxConsecutiveOnes(int[] nums) {
         int maxLen = 0;
         int curLen = 0;

         for (int num : nums) {
             if (num != 1) {
                 maxLen = Math.max(maxLen, curLen);
                 curLen = 0;
             } else {
                 curLen++;
             }
         }

         return Math.max(maxLen, curLen);
     }
 }
