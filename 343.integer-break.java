/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (47.85%)
 * Total Accepted:    80.1K
 * Total Submissions: 167.3K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */
class Solution {
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        return helper(dp, n);
    }
    
    private int helper(int[] dp, int n) {
        
        if (n <= 1) {
            return 1;
        }
        
        if (dp[n] > 0) {
            return dp[n];
        }
        
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * (n - i));
            max = Math.max(max, helper(dp, i) * (n - i));
            max = Math.max(max, i * helper(dp, n - i));
            max = Math.max(max, helper(dp, i) * helper(dp, n - i));
        }
        
        dp[n] = max;
        return max;
    }
}
