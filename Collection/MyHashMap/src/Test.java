public class Test {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("k1", 100);
        map.put("k2", 200);
        map.put("k3", 300);

        System.out.println(map.get("k1"));
        System.out.println(map.get("k8"));
        System.out.println(map.size());
        System.out.println(map.toString());
        System.out.println(map.remove("k1"));
        System.out.println(map.remove("k4"));
        System.out.println(map.toString());

        MyHashMap map1 = new MyHashMap();
        for (int i = 0; i < 100; i++) {
            map1.put("k" + i, i);
        }
        int miss = 0;
        for (int i = 0; i < 100; i++) {
            if (map1.get("k" + i) == null) miss++;
        }
        System.out.println("扩容后失联的 key 数量 = " + miss);   // 必须是 0
    }
}
