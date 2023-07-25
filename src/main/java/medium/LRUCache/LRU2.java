package medium.LRUCache;

import java.util.HashMap;

/**
 * Created by bywangxp on 2023/7/26.
 */
class LRU2 {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int maxSize;

    public LRU2(int capacity) {
        map = new HashMap<>(capacity);
        maxSize = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        // Move the accessed node to the head
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            node = new Node(null, null, key, value);

            // If the cache is full, remove the oldest node
            if (map.size() == maxSize) {
                map.remove(tail.key);
                removeNode(tail);
            }

            map.put(key, node);
            addToHead(node);
        } else {
            // Update the value of the node and move it to the head
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        if (head != null) {
            head.before = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        } else if (node == tail) {
            tail = tail.before;
            tail.next = null;
        } else {
            node.before.next = node.next;
            node.next.before = node.before;
        }

        node.before = null;
        node.next = head;
        head.before = node;
        head = node;
    }

    private void removeNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            if (head != null) {
                head.before = null;
            }
        } else if (node == tail) {
            tail = tail.before;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.before.next = node.next;
            node.next.before = node.before;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */