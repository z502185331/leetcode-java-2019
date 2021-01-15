class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        for(char task : tasks)
            f[task - 'A']++;
        Arrays.sort(f);
        int chunk = f[25] - 1;
        int idleSpots = chunk * n;
        
        for(int i = 24; i >= 0; i--) 
            idleSpots -= Math.min(chunk, f[i]);
        
        return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;
    }
    
    // wrong solution
    public int leastInterval1(char[] tasks, int n) {
        // Build a count map
        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            if (!countMap.containsKey(task)) {
                countMap.put(task, 0);
            }
            
            countMap.put(task, countMap.get(task) + 1);
        }
        
        // Build the array that contains distinct tasks
        char sortedTasks[] = sortTasks(countMap);
        
        // Build the map that record the last index the task was put
        Map<Character, Integer> indexMap = new HashMap<>();
        List<Character> taskQueue = new ArrayList<>();
        
        while (!countMap.isEmpty()) {
            boolean foundTask = false;
            for (char task : sortedTasks) {
                if (!countMap.containsKey(task) || (indexMap.containsKey(task) && indexMap.get(task) + n >= taskQueue.size())) {
                    continue;
                }
                    
                foundTask = true;
                
                // put the task at index i
                indexMap.put(task, taskQueue.size());
                taskQueue.add(task);
                
                // remove the task from the countMap
                countMap.put(task, countMap.get(task) - 1);
                if (countMap.get(task) == 0) {
                    countMap.remove(task);
                }
                    
                break;
            }
            
            // If no available task to be added, add null (idle) to the queue
            if (!foundTask) {
                taskQueue.add(null);   
            }
        }
        
        System.out.println(taskQueue);
        return taskQueue.size();
    }
    
    private char[] sortTasks(Map<Character, Integer> countMap) {
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            entries.add(entry);
        }
        
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,  
                               Map.Entry<Character, Integer> o2) { 
                return o2.getValue().compareTo(o1.getValue());
            } 
        });
        
        int i = 0;
        char sortedTasks[] = new char[entries.size()];
        for (Map.Entry<Character, Integer> entry : entries) {
            sortedTasks[i++] = entry.getKey();
        }
                
        return sortedTasks;
    }
}
