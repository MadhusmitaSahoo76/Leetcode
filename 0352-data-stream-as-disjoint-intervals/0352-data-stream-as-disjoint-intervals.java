import java.util.*;

class SummaryRanges {

    private TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {

        if (map.containsKey(value))
            return;

        Integer lower = map.floorKey(value);
        Integer higher = map.ceilingKey(value);

        if (lower != null && map.get(lower) >= value)
            return;

        boolean mergeLeft = lower != null && map.get(lower) + 1 == value;
        boolean mergeRight = higher != null && higher - 1 == value;

        if (mergeLeft && mergeRight) {
            map.put(lower, map.get(higher));
            map.remove(higher);
        } else if (mergeLeft) {
            map.put(lower, value);
        } else if (mergeRight) {
            int end = map.get(higher);
            map.remove(higher);
            map.put(value, end);
        } else {
            map.put(value, value);
        }
    }

    public int[][] getIntervals() {
        int[][] ans = new int[map.size()][2];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i][1] = entry.getValue();
            i++;
        }

        return ans;
    }
}