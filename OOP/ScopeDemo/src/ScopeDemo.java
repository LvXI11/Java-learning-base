public class ScopeDemo {
    int a = 10;
    void f(){
        int a = 20;
        System.out.println(a);
        System.out.println(this.a);
    }

    public static void main(String[] args) {
        ScopeDemo scopeDemo = new ScopeDemo();
        scopeDemo.f();
    }
}
