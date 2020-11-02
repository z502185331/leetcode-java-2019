/*
 * @lc app=leetcode id=816 lang=java
 *
 * [816] Ambiguous Coordinates
 *
 * https://leetcode.com/problems/ambiguous-coordinates/description/
 *
 * algorithms
 * Medium (44.79%)
 * Total Accepted:    10.4K
 * Total Submissions: 21.8K
 * Testcase Example:  '"(123)"'
 *
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then,
 * we removed all commas, decimal points, and spaces, and ended up with the
 * string S.  Return a list of strings representing all possibilities for what
 * our original coordinates could have been.
 *
 * Our original representation never had extraneous zeroes, so we never started
 * with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other
 * number that can be represented with less digits.  Also, a decimal point
 * within a number never occurs without at least one digit occuring before it,
 * so we never started with numbers like ".1".
 *
 * The final answer list can be returned in any order.  Also note that all
 * coordinates in the final answer have exactly one space between them
 * (occurring after the comma.)
 *
 *
 * Example 1:
 * Input: "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 *
 *
 *
 * Example 2:
 * Input: "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 *
 *
 *
 * Example 3:
 * Input: "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)",
 * "(0.12, 3)"]
 *
 *
 *
 * Example 4:
 * Input: "(100)"
 * Output: [(10, 0)]
 * Explanation:
 * 1.0 is not allowed.
 *
 *
 *
 *
 * Note:
 *
 *
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", and the other elements in S are
 * digits.
 *
 *
 *
 *
 */
 class Solution {
     public List<String> ambiguousCoordinates(String S) {
         String target = S.substring(1, S.length() - 1);
         List<String> res = new ArrayList<>();
         for (int i = 1; i < S.length() - 1; i++) {
             List<String> leftNumbers = extractNumbers(target.substring(0, i));
             List<String> rightNumbers = extractNumbers(target.substring(i, target.length()));

             for (String x : leftNumbers) {
                 for (String y: rightNumbers) {
                     res.add(buildCoordinates(x, y));
                 }
             }
         }

         return res;
     }

      private List<String> extractNumbers(String s) {

          List<String> numbers = new ArrayList<>();
          for (int i = 1; i <= s.length(); i++) {
              String left = s.substring(0, i);
              String right = s.substring(i, s.length());
              if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                  String delimeter = (i == s.length()) ? "" : ".";
                  numbers.add(left + delimeter + right);
              }
          }
          return numbers;
      }

      private String buildCoordinates(String x, String y) {
          return String.format("(%s, %s)", x, y);
      }
 }
