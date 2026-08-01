import java.util.*;

class AllOne {

    class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    private void insertAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node node;
            if (head.next != tail && head.next.count == 1) {
                node = head.next;
            } else {
                node = new Node(1);
                insertAfter(head, node);
            }
            node.keys.add(key);
            map.put(key, node);
        } else {
            Node cur = map.get(key);
            Node next = cur.next;

            if (next == tail || next.count != cur.count + 1) {
                Node node = new Node(cur.count + 1);
                insertAfter(cur, node);
                next = node;
            }

            next.keys.add(key);
            map.put(key, next);

            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                removeNode(cur);
            }
        }
    }

    public void dec(String key) {
        Node cur = map.get(key);

        if (cur.count == 1) {
            map.remove(key);
        } else {
            Node prev = cur.prev;

            if (prev == head || prev.count != cur.count - 1) {
                Node node = new Node(cur.count - 1);
                insertAfter(prev, node);
                prev = node;
            }

            prev.keys.add(key);
            map.put(key, prev);
        }

        cur.keys.remove(key);

        if (cur.keys.isEmpty()) {
            removeNode(cur);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head)
            return "";

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail)
            return "";

        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */