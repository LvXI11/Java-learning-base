public class StaticTest {
    public static void main(String[] args) {
        StaticDemo s1 = new StaticDemo();
        System.out.println(StaticDemo.count);
        StaticDemo s2 = new StaticDemo();
        System.out.println(StaticDemo.count);
        StaticDemo s3 = new StaticDemo(11,"helen");
        System.out.println(StaticDemo.count);
    }
}
