/*
 * @lc app=leetcode id=1013 lang=java
 *
 * [1013] Partition Array Into Three Parts With Equal Sum
 *
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 *
 * algorithms
 * Easy (55.92%)
 * Total Accepted:    26K
 * Total Submissions: 45.5K
 * Testcase Example:  '[0,2,1,-6,6,-7,9,1,2,0,1]'
 *
 * Given an array A of integers, return true if and only if we can partition
 * the array into three non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i+1 < j with
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1]
 * + ... + A[A.length - 1])
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 *
 *
 * Example 2:
 *
 *
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 *
 *
 *
 * Example 3:
 *
 *
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 *
 */
 class Solution {

     public boolean canThreePartsEqualSum(int[] A) {
         int sum = 0;
         for (int a : A) {
             sum += a;
         }

         if (sum % 3 != 0) {
             return false;
         }

         int subSum = sum / 3;
         int curSum = 0;
         int count = 0;

         for (int a : A) {
             curSum += a;

             if (curSum == subSum) {
                 count++;
                 if (count == 2) {
                     return true;
                 }

                 curSum = 0;
             }
         }

         return false;
     }

     // PreSum
     public boolean canThreePartsEqualSum1(int[] A) {
         int[] preSum = new int[A.length];

         int sum = 0;
         for (int i = 0; i < A.length; i++) {
             sum += A[i];
             preSum[i] = sum;
         }

         for (int i = 0; i < A.length - 1; i++) {
             for (int j = i + 1; j < A.length; j++) {
                 int sum1 = preSum[i];
                 int sum2 = preSum[j] - preSum[i];
                 int sum3 = preSum[A.length - 1] - preSum[j];

                 if (sum1 == sum2 && sum2 == sum3) {
                     return true;
                 }
             }
         }

         return false;
     }
 }
