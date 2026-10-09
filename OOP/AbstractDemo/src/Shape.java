public abstract class Shape {
    private String name;

    abstract double area();

    public Shape(String name) {
        this.name = name;
    }

    String getName(){
        return name;
    }
}
