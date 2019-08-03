class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {

        int n = books.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int height = books[i][1];
            int width = books[i][0];

            dp[i + 1] = dp[i] + height;

            for (int j = i - 1; j >= 0; j--) {
                height = Math.max(height, books[j][1]);
                width += books[j][0];

                if (width > shelf_width) {
                    break;
                }

                dp[i + 1] = Math.min(dp[i + 1], dp[j] + height);
            }
        }

        return dp[n];
    }
}
