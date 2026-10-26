public class Outer {
    private int outerField = 100;
    private String secret = "密码";

    public Outer() {

    }

    public int getOuterField() {
        return outerField;
    }

    public String getSecret() {
        return secret;
    }

    class Inner {
        void test() {
            System.out.println(outerField);
            outerField = 0;
            System.out.println(outerField);
            System.out.println(secret);
            secret = "可见";
            System.out.println(secret);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.getOuterField());
        System.out.println(outer.getSecret());
        Outer.Inner inner =  outer.new Inner();
        inner.test();


       Greeting greeting = new Greeting() {
           @Override
           public void say(String name) {
               System.out.println("你好，" + name);
           }
       };
       greeting.say("张三");
    }
}

interface Greeting {
    void say(String name);
}
