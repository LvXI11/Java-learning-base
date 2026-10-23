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

    public void put(Object key, Object value) {
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


    public String toStirng() {
        int count = 0;
        for(int i = 0;i < table.length; i++) {
            Node curr = table[i];
            while (curr != null) {
                count++;
                curr = curr.next;
            }
        }

        if(count == 0) {
            return "{}";
        }

        String s = "{";
        for (int i = 0; i < table.length && count > 0; i++) {
            Node curr = table[i];

            while(curr != null) {
              s = s + curr.key + "=" + curr.value + ",";
              curr = curr.next;
              count--;
              if(count == 1 && curr != null) {
                  s = s + curr.key + "=" + curr.value;
                  count--;
              }
             }
        }
        return s;
    }
}
