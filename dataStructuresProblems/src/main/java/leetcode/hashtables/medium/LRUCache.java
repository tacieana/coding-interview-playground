package leetcode.hashtables.medium;

import java.util.HashMap;

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Runtime: 61.35% / Memory: 84.35%
public class LRUCache {

    private int capacity, size;
    private HashMap<Integer,Node> values;
    Node first, last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        values = new HashMap();
        first = new Node(-1,-1);
        last = new Node(-1,-1);
        first.next = last;
        last.previous = first;
    }

    public int get(int key) {
        if (values.containsKey(key)) {
            Node node = values.get(key);
            moveToFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (values.containsKey(key)) {
            Node node = values.get(key);
            node.value = value;
            moveToFirst(node);
        }
        else {
            if (size == capacity) {
                values.remove(last.previous.key);
                removeNode(last.previous);
                size--;
            }

            Node newNode = new Node(key, value);
            addFirstNode(newNode);
            values.put(key, newNode);
            size++;
        }
    }

    private void addFirstNode(Node node) {
        node.previous = first;
        node.next = first.next;
        first.next.previous = node;
        first.next = node;
    }

    private void removeNode(Node node) {
        Node prevNode = node.previous;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.previous = prevNode;
    }

    private void moveToFirst(Node node) {
        removeNode(node);
        addFirstNode(node);
    }

    private class Node {
        public int key, value;
        public Node previous, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
