public class Duck implements Swimmable,Flyable{
    @Override
    public void swim() {
        System.out.println("鸭子游泳");
    }

    @Override
    public void fly() {
        System.out.println("鸭子飞");
    }
}

class InterfaceTest{
    public static void main(String[] args) {
        Flyable f1 = new Duck();
        f1.fly();

        Duck d1 = new Duck();
        d1.swim();
    }
}
