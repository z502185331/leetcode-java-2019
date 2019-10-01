/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (36.35%)
 * Total Accepted:    88.9K
 * Total Submissions: 242.9K
 * Testcase Example:  '5\n7'
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 *
 * Input: [5,7]
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: [0,1]
 * Output: 0
 */
 class Solution {
 //     public int rangeBitwiseAnd(int m, int n) {
 //         int res = 0x7FFFFFFF;
 //         int left = m, right = n;

 //         while (left <= right) {
 //             res &= left;

 //             if (left == right || res == 0) {
 //                 break;
 //             }

 //             left++;
 //         }

 //         return res;
 //     }

     public int rangeBitwiseAnd(int m, int n) {
         int shift = 0;
         while (m != 0 && m != n) {
             m >>= 1;
             n >>= 1;
             shift++;
         }

         return m << shift;
     }
 }
