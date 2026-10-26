public class StaticDemo {
    private int id;
    private  String name;
    static int count = 0;

    public StaticDemo(){
        count++;
    }

    public StaticDemo(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    static{
        System.out.println("static静态代码块");
//        System.out.println(name);  static不能引用非static变量
//        static的变量和方法是通过 类.变量/方法 直接使用
//        而非静态的成员变量和方法只能通过 实例.变量/方法
        System.out.println("count = " + count);
    }

    {
        System.out.println("非静态代码块");
        System.out.println("count = " + count);
    }
}
