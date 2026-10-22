public class Test {
    public static void main(String[] args) {
        //基础操作
        MyArrayList m1 = new MyArrayList();
        m1.add("A");
        m1.add("B");
        m1.add("C");
        System.out.println(m1.toString() + " size = " + m1.size());

        m1.add(1,"X");
        System.out.println(m1.toString() + " size = " + m1.size());

        System.out.println(m1.get(2));

        System.out.println(m1.set(0,"Z"));
        System.out.println(m1.toString() + " size = " + m1.size());

        m1.remove(1);
        System.out.println(m1.toString() + " size = " + m1.size());

        System.out.println(m1.isEmpty());
        System.out.println("--------------------------");

        //扩容
        MyArrayList m2 = new MyArrayList();
        m2.add("A");
        m2.add("B");
        m2.add("C");

        for (int i = 0; i < 100; i++) {
            m2.add("i" + i);
        }
        System.out.println(" size = " + m2.size());

        System.out.println(m2.get(0));
        System.out.println(m2.get(2));
        System.out.println(m2.get(3));
        System.out.println(m2.get(102));

        //越界
//        m2.get(1000);IndexOutOfBoundsException
//        m2.get(-1);IndexOutOfBoundsException

        //清空
        m2.clear();
        System.out.println(m2.toString() + " size = " + m2.size());

        System.out.println("*********************");
        System.out.println("get(105) = " + m2.get(105));       // 你觉得会发生什么？
        m2.set(108, "Y");                                       // 会报错吗？
        System.out.println("set 之后 size = " + m2.size());

        System.out.println();

        MyArrayList m3 = new MyArrayList();
        m3.add("A"); m3.add("B"); m3.add("C");
        m3.add(5, "X");                                         // 在只有 3 个元素时插到位置 5
        System.out.println(m3.toString() + " size = " + m3.size());
    }
}
