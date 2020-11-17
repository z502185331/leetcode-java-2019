/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 *
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
 *
 * algorithms
 * Medium (35.19%)
 * Total Accepted:    22.1K
 * Total Submissions: 60.6K
 * Testcase Example:  '"123456579"'
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a
 * Fibonacci-like sequence [123, 456, 579].
 *
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers
 * such that:
 *
 *
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer
 * type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 *
 *
 * Also, note that when splitting the string into pieces, each piece must not
 * have extra leading zeroes, except if the piece is the number 0 itself.
 *
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot
 * be done.
 *
 * Example 1:
 *
 *
 * Input: "123456579"
 * Output: [123,456,579]
 *
 *
 * Example 2:
 *
 *
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 *
 *
 * Example 3:
 *
 *
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 *
 *
 * Example 4:
 *
 *
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not
 * valid.
 *
 *
 * Example 5:
 *
 *
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 *
 *
 * Note:
 *
 *
 * 1 <= S.length <= 200
 * S contains only digits.
 *
 *
 */
 
 class Solution {
     public List<Integer> splitIntoFibonacci(String S) {
         List<Integer> res = new ArrayList<>();

         for (int i = 1; i < S.length(); i++) {
             for (int j = 1; i + j < S.length(); j++) {
                 String n1 = S.substring(0, i);
                 String n2 = S.substring(i, i + j);

                 if (!validate(n1) || !validate(n2)) {
                     break;
                 }

                 res.add(Integer.valueOf(n1));
                 res.add(Integer.valueOf(n2));
                 if (helper(Integer.valueOf(n1), Integer.valueOf(n2), S, i + j, res)) {
                     return res;
                 }
                 res.clear();
             }
         }

         return res;
     }

     private boolean helper(int n1, int n2, String s, int index, List<Integer> l) {
         if (index >= s.length()) {
             return true;
         }

         int sum = n1 + n2;

         if (!s.substring(index).startsWith(Integer.toString(sum))) {
             return false;
         }

         l.add(sum);
         if (!helper(n2, sum, s, Integer.toString(sum).length() + index, l)) {
             l.remove(l.size() - 1);
             return false;
         }

         return true;
     }

     private boolean validate(String s) {
         try {
             Integer.valueOf(s);
             return !s.startsWith("0") || "0".equals(s);
         } catch (NumberFormatException e) {
             return false;
         }
     }
 }
