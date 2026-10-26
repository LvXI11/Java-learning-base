public class FinalDemo {
    final  int CONST;

    public FinalDemo() {
//        CONST = 1; 代码块内已经赋值一次了（代码块先于构造器内部代码块执行）,
//        final关键字修饰的变量只能被赋值一次，
    }

    {
        CONST = 2;
    }
}

final class A{

}

//A不能被继承
//class B extends A{
//
//}

class  C{
    final public void eat(){

    }
}

class D extends C{
//    @Override
//    public void eat() {
//
//    }
//    final修饰的方法不能被重写
}