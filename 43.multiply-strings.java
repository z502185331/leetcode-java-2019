/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (31.30%)
 * Total Accepted:    258.8K
 * Total Submissions: 792.1K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 *
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Note:
 *
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 *
 *
 */
 class Solution {
     public String multiply(String num1, String num2) {
         if (num1.equals("0") || num2.equals("0")) {
             return "0";
         }

         String val = "0";

         for (int i = 0; i < num2.length(); i++) {
             String v = multiplyHelper(num1, num2.charAt(num2.length() - i - 1) - '0', i);
             val = add(val, v);
         }

         return val;
     }

     private String multiplyHelper(String num, int digit, int pos) {
         StringBuilder sb = new StringBuilder();

         int i = 0;
         int c = 0;
         while (i < num.length() || c != 0) {
             int v = c;

             if (i < num.length()) {
                 v += digit * (num.charAt(num.length() - i - 1) - '0');
             }

             c = v / 10;
             sb.insert(0, v % 10);
             i++;
         }

         while (pos-- > 0) {
             sb.append('0');
         }

         return sb.toString();
     }

     private String add(String num1, String num2) {
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
