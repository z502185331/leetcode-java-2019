class Solution {
    public int[] shortestToChar(String s, char c) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                queue.offer(i);
            }
        }
        
        // the indexex size is at least 1 because of problem constraints
        int[] res = new int[s.length()];
        int pos1 = queue.poll();
        int pos2 = queue.isEmpty() ? Integer.MAX_VALUE : queue.poll();
        
        for (int i = 0; i < s.length(); i++) {
            if (i > pos2 && !queue.isEmpty()) {
                pos1 = pos2;
                pos2 = queue.poll();
            }
            
            res[i] = Math.min(Math.abs(pos1 - i), Math.abs(pos2 - i));             
        }
        
        return res;
    }
}
