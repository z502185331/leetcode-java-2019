/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 *
 * https://leetcode.com/problems/set-mismatch/description/
 *
 * algorithms
 * Easy (40.76%)
 * Total Accepted:    48.4K
 * Total Submissions: 118.6K
 * Testcase Example:  '[1,2,2,4]'
 *
 *
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 *
 *
 *
 * Given an array nums representing the data status of this set after the
 * error. Your task is to firstly find the number occurs twice and then find
 * the number that is missing. Return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 *
 *
 * Note:
 *
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 *
 *
 */
 class Solution {
     public int[] findErrorNums(int[] nums) {
         int cur = 0;
         int dup = 0;
         int missing = 0;

         while (cur < nums.length) {
             // when the number is on the right position
             if (nums[cur] == cur + 1) {
                 cur++;
                 continue;
             }

             // If the place where to put the number already has the same number
             // then this is duplicate number
             if (nums[nums[cur] - 1] == nums[cur]) {
                 dup = nums[cur];
                 cur++;
                 continue;
             }

             // Swap the number
             int tmp = nums[nums[cur] - 1];
             nums[nums[cur] - 1] = nums[cur];
             nums[cur] = tmp;
         }

         for (int i = 0; i < nums.length; i++) {
             if (i + 1 != nums[i]) {
                 missing = i + 1;
             }
         }

         return new int[]{dup, missing};
     }
 }
