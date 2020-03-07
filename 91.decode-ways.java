/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.69%)
 * Total Accepted:    346.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 *
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 *
 * Example 1:
 *
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 *
 * Example 2:
 *
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 *
 */
 class Solution {
     public int numDecodings(String s) {

         if (s.length() == 0 || s.startsWith("0")) {
             return 0;
         }

         int[] dp = new int[s.length() + 1];
         dp[0] = 1;
         dp[1] = 1;

         for (int i = 1; i < s.length(); i++) {
             // '0' cannot be a single letter
             if (s.charAt(i) != '0') {
                 dp[i + 1] += dp[i];
             }

             // Check if most recent two digits form a number not bigger than 26
             if (s.charAt(i - 1) != '0') {
                 int num = Integer.valueOf("" + s.charAt(i - 1) + s.charAt(i));
                 if (num <= 26) {
                     dp[i + 1] += dp[i - 1];
                 }
             }
         }

         return dp[s.length()];
     }
 }
