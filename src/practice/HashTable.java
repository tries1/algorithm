package practice;

import java.util.LinkedList;

public class HashTable {

    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data;

    public HashTable(int size) {
        data = new LinkedList[size];
    }

    public int getHashCode(String s) {
        char hashcode = 0;
        for (char c : s.toCharArray()) {
            hashcode += c;
        }

        return hashcode;
    }

    public int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    public void put(String key, String value) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);

        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }

        Node node = searchKey(list, key);
        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    public String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];

        Node node = searchKey(list, key);
        return (node == null) ? "Not Found" : node.value;
    }

    public Node searchKey(LinkedList<Node> list, String key) {
        if (list.isEmpty()) {
            return null;
        }

        for (Node node : list) {
            if (key.equals(node.key)) {
                return node;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("glenn1", "awesome1!!");
        h.put("glenn2", "awesome2!!");
        h.put("glenn3", "awesome3!!");

        System.out.println(h.get("glenn1"));
        System.out.println(h.get("glenn2"));
        System.out.println(h.get("glenn3"));
        h.put("glenn1", "new awesome1!!");
        System.out.println(h.get("glenn1"));
    }
}
