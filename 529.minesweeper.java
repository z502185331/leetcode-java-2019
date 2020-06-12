class Solution {
    
    private static final int[][] DIRS = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        board[click[0]][click[1]] = 'B';
        int mineCount = 0;
        for (int[] dir : DIRS) {
            int x = click[0] + dir[0];
            int y = click[1] + dir[1]; 
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'B') {
                continue;
            }
            
            if (board[x][y] == 'M') {
                mineCount++;
            }
        }
        
        if (mineCount > 0) {
            board[click[0]][click[1]] = (char)(mineCount + '0');
        } else {
            for (int[] dir : DIRS) {
                int x = click[0] + dir[0];
                int y = click[1] + dir[1]; 

                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }

                updateBoard(board, new int[]{x, y});
            }
        }
        
        return board;
    }
}
