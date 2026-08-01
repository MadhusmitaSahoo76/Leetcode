import java.util.*;

class RandomizedCollection {

    private ArrayList<Integer> list;
    private HashMap<Integer, Set<Integer>> map;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val) || map.get(val).isEmpty();

        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);

        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        Iterator<Integer> it = map.get(val).iterator();
        int removeIndex = it.next();

        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);

        // Remove the index of val
        map.get(val).remove(removeIndex);

        if (removeIndex != lastIndex) {
            list.set(removeIndex, lastValue);

            map.get(lastValue).remove(lastIndex);
            map.get(lastValue).add(removeIndex);
        }

        list.remove(lastIndex);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */