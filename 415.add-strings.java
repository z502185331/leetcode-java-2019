/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.29%)
 * Total Accepted:    145.5K
 * Total Submissions: 316.2K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 *
 *
 */
 class Solution {
     public String addStrings(String num1, String num2) {
         int i = 0;
         int c = 0;
         StringBuilder sb = new StringBuilder();

         while (num1.length() > i || num2.length() > i || c != 0) {
             int v = c;

             if (i < num1.length()) {
                 v += Character.getNumericValue(num1.charAt(num1.length() - 1 - i));
             }

             if (i < num2.length()) {
                 v += Character.getNumericValue(num2.charAt(num2.length() - 1 - i));
             }

             c = v / 10;
             sb.insert(0, v % 10);
             i++;
         }

         return sb.toString();
     }
 }
