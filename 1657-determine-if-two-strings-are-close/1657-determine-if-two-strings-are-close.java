class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m != n)
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : word1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);

        for (char c : word2.toCharArray()) {
            if (!map1.containsKey(c))
                return false;
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer i : map1.values())
            arr.add(i);

        for (Integer i : map2.values())
            if (arr.contains(i))
                arr.remove(i);
            else
                return false;

        return arr.isEmpty();
    }
}