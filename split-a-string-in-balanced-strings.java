class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;

        int lCount = 0;
        int rCount = 0;
        for (char c : s.toCharArray())  {
            if (c == 'R') {
                rCount++;
            } else {
                lCount++;
            }

            if (rCount != 0 && rCount == lCount) {
                count++;
                rCount = 0;
                lCount = 0;
            }
        }

        return count;
    }
}
