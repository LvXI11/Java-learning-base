package com.lv.annotationdemo;

//@MyTest
//'@MyTest' not applicable to type
public class AnnotationDemo {
    @MyTest
    public void test1() { }

    @MyTest("登录用例")
    public void test2() { }

    @MyTest(value = "下单用例")
    public void test3() { }

    @SuppressWarnings({"deprecation", "fallthrough"})
    public static void main(String[] args) {
        OldUtil.oldAdd();//'oldAdd()' is deprecated

        Person p1 = new Person();
        System.out.println(p1);
        Student s1 = new Student();
        System.out.println(s1.toString());

        System.out.println("去掉Override并拼错toString方法 " + s1.ToString());
//        @MyTest   not applicable to local variable
        int choice ;
        for(int i = 0;i < 5; i++){
            choice = i;

            switch (choice){
                case 1:
                    System.out.println("one");     // ★ 有语句
                    // ★ 没 break → 掉进 case 2
                case 2:
                    System.out.println("two");
                    break;
                default:
                    break;
            }
        }

//        AnnotationDemo a1 = new AnnotationDemo();
//        a1.test1();
//        a1.test2();
//        a1.test3();
//        那个value被赋值了有什么用呢

    }
}

class Person{
    @Override
    public String toString() {
        return "Person";
    }
}

class Student extends Person{
    //    @Override     Method does not override method from its superclass
    public String ToString() {
        return "Student";
    }
}
