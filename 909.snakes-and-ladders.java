class Solution {
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        // Flatten the board
        int[] path = new int[n * n + 1];
        int pos = 1;
        boolean forward = false;
        for(int i = n - 1; i >= 0; i--) {
            forward = !forward; // Snake traverse
            int j = forward ? 0 : n - 1;
            
            while (j >= 0 && j < n) {
                path[pos++] = board[i][j];
                j += forward ? 1 : -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        int step = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
                        
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                
                if (visited.contains(cur)) {
                    continue;
                }
                
                
                if (cur == n * n) {
                    return step;
                }
                
                for (int j = 1; j <= 6 && cur + j <= n * n; j++) {
                    if (path[cur + j] == -1) {
                        queue.offer(cur + j);
                    } else {
                        queue.offer(path[cur + j]);
                    }
                }
                visited.add(cur);
            }
            
            step++;
        }
        
        return -1;
    }
}
