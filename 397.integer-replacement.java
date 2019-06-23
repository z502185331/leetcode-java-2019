/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (31.45%)
 * Total Accepted:    41.3K
 * Total Submissions: 131K
 * Testcase Example:  '8'
 *
 *
 * Given a positive integer n and you can do operations as follow:
 *
 *
 *
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 *
 *
 *
 *
 * What is the minimum number of replacements needed for n to become 1?
 *
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 8
 *
 * Output:
 * 3
 *
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 *
 *
 *
 * Example 2:
 *
 * Input:
 * 7
 *
 * Output:
 * 4
 *
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 *
 */
class Solution {
    public int integerReplacement(int n) {
        if (n == 0) {
            return 0;
        }

        Map<Long, Integer> dp = new HashMap<>();
        return helper(dp, Long.valueOf(n));
    }

    private int helper(Map<Long, Integer> dp, long n) {
        if (n == 1) {
            return 0;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        
        if (n % 2 == 0) {
            dp.put(n, helper(dp, n / 2) + 1);
        } else {
            dp.put(n, Math.min(helper(dp, n + 1), helper(dp, n - 1)) + 1);
        }

        return dp.get(n);
    }
}
