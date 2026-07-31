import java.util.HashMap;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int ele : arr) {
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }

        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int count : freq.values()) {
            seen.put(count, seen.getOrDefault(count, 0) + 1);

            if (seen.get(count) > 1) {
                return false;
            }
        }

        return true;
    }
}