/*
 * @lc app=leetcode id=1052 lang=java
 *
 * [1052] Grumpy Bookstore Owner
 *
 * https://leetcode.com/problems/grumpy-bookstore-owner/description/
 *
 * algorithms
 * Medium (52.69%)
 * Total Accepted:    17.3K
 * Total Submissions: 31.8K
 * Testcase Example:  '[1,0,1,2,1,1,7,5]\n[0,1,0,1,0,1,0,1]\n3'
 *
 * Today, the bookstore owner has a store open for customers.length minutes.
 * Every minute, some number of customers (customers[i]) enter the store, and
 * all those customers leave after the end of that minute.
 *
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is
 * grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the
 * bookstore owner is grumpy, the customers of that minute are not satisfied,
 * otherwise they are satisfied.
 *
 * The bookstore owner knows a secret technique to keep themselves not grumpy
 * for X minutes straight, but can only use it once.
 *
 * Return the maximum number of customers that can be satisfied throughout the
 * day.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3
 * minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 +
 * 5 = 16.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 *
 */
 class Solution {
     public int maxSatisfied(int[] customers, int[] grumpy, int X) {

         int baseSatisfied = 0;
         for (int i = 0; i < customers.length; i++) {
             if (grumpy[i] == 0) {
                 baseSatisfied += customers[i];
             }
         }

         // find the maximum sum of sliding window of X
         int slow = 0;
         int satisfied = 0;
         int maxSatisfied = 0;
         for (int cur = 0; cur < customers.length; cur++) {
             if (grumpy[cur] == 1) {
                 satisfied += customers[cur];
             }

             if (cur >= X) {
                 if (grumpy[slow] == 1) {
                     satisfied -= customers[slow];
                 }

                 slow++;
             }

             maxSatisfied = Math.max(maxSatisfied, satisfied);
         }

         return baseSatisfied + maxSatisfied;
     }
 }
