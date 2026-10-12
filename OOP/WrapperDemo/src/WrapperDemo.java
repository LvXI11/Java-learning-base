public class WrapperDemo {
    public static void main(String[] args) {
        System.out.println("======1.自动装箱/拆箱======");
        Integer a  = 12;
        System.out.println(a);
        int b = a;
        System.out.println(b);

        System.out.println("=====2.Integer缓存陷阱======");
        Integer a1 = 127;
        Integer c1 = 127;
        System.out.println(a1 == c1);//true
        System.out.println(a1 == 127);//true
        System.out.println(a1.equals("127"));//true

        Integer b1 = 128;
        Integer d1 = 128;
        System.out.println(b1 == d1);//false
        System.out.println(b1 == 128);//true
        System.out.println(b1.equals(128));//true

        Integer c = 129;
        Integer c2 = 129;
        System.out.println(c == c2);//false
        System.out.println(c == 129);//true
        System.out.println(c.equals(129));//true

        System.out.println("======3.缓存边界扫描======");
        for (int i = -200; i <= 200; i++) {
            Integer x = i;
            Integer y = i;
            if(x == y){
                System.out.println(i + " true");
            }else{
                System.out.println(i + " false");
            }
        }

        System.out.println("======4.字符串 <-> 数字=====");
        Integer a3 = Integer.parseInt("123");
        int b3 = a3;
        System.out.println(a3 == b3);
        a3 = Integer.valueOf("321");
        String d = String.valueOf(a3);
        System.out.println(d);//为什么这里打印的是321，而不是哈希值，是因为321是常量吗

        System.out.println("=====5.null拆箱======");
        Integer x = null;
        int y = x;
//        NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "x" is null
//        	at WrapperDemo.main(WrapperDemo.java:43)
    }
}
