/*
 * @lc app=leetcode id=1073 lang=java
 *
 * [1073] Adding Two Negabinary Numbers
 *
 * https://leetcode.com/problems/adding-two-negabinary-numbers/description/
 *
 * algorithms
 * Medium (31.27%)
 * Total Accepted:    2.7K
 * Total Submissions: 8.8K
 * Testcase Example:  '[1,1,1,1,1]\n[1,0,1]'
 *
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them
 * together.
 *
 * Each number is given in array format:  as an array of 0s and 1s, from most
 * significant bit to least significant bit.  For example, arr = [1,1,0,1]
 * represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array
 * format is also guaranteed to have no leading zeros: either arr == [0] or
 * arr[0] == 1.
 *
 * Return the result of adding arr1 and arr2 in the same format: as an array of
 * 0s and 1s with no leading zeros.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * Output: [1,0,0,0,0]
 * Explanation: arr1 represents 11, arr2 represents 5, the output represents
 * 16.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 and arr2 have no leading zeros
 * arr1[i] is 0 or 1
 * arr2[i] is 0 or 1
 *
 */
class Solution {
  public int[] addNegabinary(int[] arr1, int[] arr2) {
     LinkedList<Integer> res = new LinkedList<>();

     int n1 = arr1.length;
     int n2 = arr2.length;

     int c = 0;
     int i = 0;
     while (n1 - i - 1 >= 0 || n2 - i - 1 >= 0 || c != 0) {
         int num1 = n1 - i - 1 >= 0 ? arr1[n1 - i - 1] : 0;
         int num2 = n2 - i - 1 >= 0 ? arr2[n2 - i - 1] : 0;

         int sum  = num1 + num2 + c;

         res.addFirst(sum & 1);
         c = -1 * (sum >> 1);
         i++;
     }

     int cur = 0;
     while (cur < res.size() - 1 && res.get(cur) == 0) {
         cur++;
     }

     int[] resArr = new int[res.size() - cur];
     for (int j = 0; j < resArr.length; j++) {
         resArr[j] = res.get(cur + j);
     }

     return resArr;

 }
}
