class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        
        Deque<String> queue = new LinkedList<>();
        for (String part : parts) {
            if (".".equals(part) || part.length() == 0) {
                continue;
            } else if ("..".equals(part)) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offerLast(part);
            }
        }
        
        // assemble the path
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append("/").append(queue.pollFirst());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
