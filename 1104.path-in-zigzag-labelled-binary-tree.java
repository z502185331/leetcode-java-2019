class Solution {

    /**
    Recursion
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();
        collectPath(label, path);
        return path;
    }

    private void collectPath(int label, List<Integer> path) {
        path.add(0, label);

        if (label == 1) {
            return;
        }

        // try to find previous label
        int total = 0, p = 0;
        while ((total += Math.pow(2, p)) < label) {
            p++;
        }

        // The current label is from left to right
        double prevTotal = total - Math.pow(2, p);
        double offset = Math.ceil((label - prevTotal) / 2);
        double previousLabel = prevTotal - offset + 1;

        collectPath((int) previousLabel, path);
    }
    */

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();

        int pow = 1;
        while (pow <= label) {
            pow *= 2;
        }

        while (label != 0) {
            path.add(0, label);
            label = pow - label + pow / 2 - 1;
            label /=2;
            pow /= 2;
        }

        return path;
    }

}
