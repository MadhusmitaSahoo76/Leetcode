class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by earliest ending time
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int removed = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {

            // No overlap → keep this interval
            if (interval[0] >= lastEnd) {
                lastEnd = interval[1];
            } 
            // Overlap → remove current interval
            else {
                removed++;
            }
        }

        return removed;
    }
}