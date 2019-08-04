/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (36.14%)
 * Total Accepted:    131.2K
 * Total Submissions: 359.1K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 *
 * Example:
 *
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 *
 */
 class Solution {
     public List<String> findRepeatedDnaSequences(String s) {
         List<String> res = new ArrayList<>();
         if (s == null || s.length() <= 10) {
             return res;
         }

         Map<String, Integer> count = new HashMap<>();

         for (int i = 0; i + 9 < s.length(); i++) {
             String subS = s.substring(i, i + 10);

             if (count.containsKey(subS) && count.get(subS) == 1) {
                 res.add(subS);
             }

             if (!count.containsKey(subS)) {
                 count.put(subS, 0);
             }

             count.put(subS, count.get(subS) + 1);
         }

         return res;
     }
 }
