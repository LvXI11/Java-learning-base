public class Test {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("k1", 100);
        map.put("k2", 200);
        map.put("k3", 300);

        System.out.println(map.get("k1"));
        System.out.println(map.get("k8"));
        System.out.println(map.size());
        System.out.println(map.toStirng());
    }
}
