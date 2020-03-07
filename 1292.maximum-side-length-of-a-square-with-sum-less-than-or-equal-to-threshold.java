class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        int n = mat.length;
        int m = mat[0].length;

        // Calculate the matrix presum
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j + 1] = mat[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n - maxLen; i++) {
            for (int j = 0; j < m - maxLen; j++) {

                while (i + maxLen < n && j + maxLen < m && measureArea(sum, i, j, maxLen + 1) <= threshold)  {
                    maxLen++;
                }
            }
        }

        return maxLen;
    }

    private int measureArea(int[][] sum, int i, int j, int len) {
        int ii = i + len;
        int jj = j + len;

        return sum[ii][jj] - sum[ii][j] - sum[i][jj] + sum[i][j];
    }
}
