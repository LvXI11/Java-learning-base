package com.lv.myhashmap;

public class MyHashMap {
    static class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[16];
    }

    private int hash(Object key) {
        int h = key.hashCode();
        return (h % table.length + table.length) % table.length;
    }
    private Node[] extendCapacity() {
        Node[] newTable = new Node[table.length * 2];
        for(int i = 0;i < table.length; i++) {
            Node curr = table[i];
            while(curr != null) {
                int index = (curr.key.hashCode() % newTable.length
                        + newTable.length) % newTable.length;
                Node next = curr.next;
                curr.next = newTable[index];
                newTable[index] = curr;
                curr = next;
            }
        }
        return newTable;
    }

    public void put(Object key, Object value) {
        if(size > table.length * 3 / 4) {
            table = extendCapacity();
        }
        int index = hash(key);
        Node curr = table[index];
        while(curr != null) {
            if(curr.key.equals(key)) {
                curr.value = value;
                return;
            } else {
                curr = curr.next;
            }
        }
        Node node = new Node(key, value);
        node.next = table[index];
        table[index] = node;
        size++;
    }

    public Object get(Object key) {
        int index = hash(key);
        Node curr = table[index];
        while(curr != null) {
            if(curr.key.equals(key)) {
                return curr.value;
            } else {
                curr = curr.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Object remove(Object key) {
        int index = hash(key);
        Node prev = null;
        Node curr = table[index];
        if(curr == null) {
            return null;
        }
        if(curr.key.equals(key)) {
            table[index] = curr.next;
            size--;
            return curr.value;
        } else {
            prev = curr;
            curr = curr.next;
            while(curr != null) {
                if(curr.key.equals(key)) {
                    prev.next = curr.next;
                    size--;
                    return curr.value;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        boolean empty = true;
        for(int i = 0;i < table.length; i++) {
           if(table[i] != null) {
               empty = false;
           }
        }
        if(empty) {
            return "{}";
        }

        String s = "{";
        boolean first = true;
        for (int i = 0; i < table.length; i++) {
            Node curr = table[i];
            while(curr != null) {
              if(!first) {
                  s += ",";
              }
              s += curr.key + "=" + curr.value;
              first = false;
              curr = curr.next;
             }
        }
        return s + "}";
    }

}
