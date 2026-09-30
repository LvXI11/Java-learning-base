public class OverLoadDemo {
    static int add(int a,int b) {return a+b;}
    static int add(int a,int b,int c) {return a+b+c;}
    static double add(double a,double b) {return a+b;}
    static String add(String a,String b) {return a+b;}
//    static double add(int a,int b) {return a+b;}
//    为什么返回值不一样也不行呢
}
