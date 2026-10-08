public class FieldTest {

//    {
//        count++;
//    }
//    为什么这里这样写会报错呢，不是先生成类的变量再执行代码块那些吗，你给我细致的讲讲类在内存中实际
//    创建过程中执行代码的优先顺序
    static int count = 0;

    {
        System.out.println("代码块内的count++" + "  count = " + ++count);
    }

    public FieldTest() {

        System.out.println("构造器内的count++" + "  count = " + ++count);
    }

    public static void main(String[] args) {
        FieldTest f1 = new FieldTest();
        FieldTest f2 = new FieldTest();
        f1 = null;
        f2 = null;

//        这里count没有被重置是因为GC清理的堆里面的东西，static是在哪里的，是属于类吗
//        只有类被销毁才会被销毁吗
        System.out.println();
        FieldTest f3 = new FieldTest();
        FieldTest f4 = new FieldTest();

    }
}
