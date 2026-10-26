public class AbstractDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(12);
        shapes[1] = new Rectangle(10,21);

        System.out.println(shapes[0].getName() + " " + shapes[0].area());
        System.out.println(shapes[1].getName() + " " + shapes[1].area());
    }
}
