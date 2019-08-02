/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.09%)
 * Total Accepted:    601.2K
 * Total Submissions: 2.5M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 *
 *
 */
 class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();

         if (nums == null || nums.length == 0) {
             return res;
         }

         Arrays.sort(nums);

         // Use three pointers to find all the res
         for (int left = 0; left < nums.length - 2; left = findNextDistinct(nums, left, 1)) {
             int mid = left + 1;
             int right = nums.length - 1;

             while (mid < right) {
                 int sum = nums[left] + nums[mid] + nums[right];
                 if (sum == 0) {
                     List<Integer> l = new ArrayList<>();
                     l.add(nums[left]);
                     l.add(nums[mid]);
                     l.add(nums[right]);
                     res.add(l);

                     mid = findNextDistinct(nums, mid, 1);
                     right = findNextDistinct(nums, right, -1);
                 } else if (sum > 0) {
                     right = findNextDistinct(nums, right, -1);
                 } else {
                     mid = findNextDistinct(nums, mid, 1);
                 }
             }
         }

         return res;
     }

     private int findNextDistinct(int[] nums, int base, int offset) {
         int i = base;

         while (i < nums.length && i >= 0 && nums[base] == nums[i]) {
             i += offset;
         }

         return i;
     }
 }
