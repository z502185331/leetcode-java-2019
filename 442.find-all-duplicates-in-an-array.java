/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 * algorithms
 * Medium (61.11%)
 * Total Accepted:    105.5K
 * Total Submissions: 171K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 *
 */
 class Solution {

     /**
      * Extra space
     public List<Integer> findDuplicates(int[] nums) {
         List<Integer> res = new ArrayList<>();

         if (nums == null || nums.length == 0) {
             return res;
         }

         int n = nums.length;
         int[] cache = new int[n + 1];

         for (int num : nums) {
             if (cache[num] == num && !res.contains(num)) {
                 res.add(num);
                 continue;
             }

             cache[num] = num;
         }

         return res;
     }
     */

     public List<Integer> findDuplicates(int[] nums) {
         List<Integer> res = new ArrayList<>();

         if (nums == null || nums.length == 0) {
             return res;
         }

         for (int i = 0; i < nums.length; i++) {
             int index = Math.abs(nums[i]) - 1;

             if (nums[index] < 0) {
                 res.add(index + 1);
             } else {
                 nums[index] = -nums[index];
             }
         }

         return res;
     }

 }
