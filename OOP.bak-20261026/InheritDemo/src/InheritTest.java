public class InheritTest {

    public static void main(String[] args) {

        Student student = new Student("张三",17,"软件工程","成人大学");
        Teacher teacher = new Teacher("老李",56,"物理",33);

        System.out.println(student.getInfo());
        System.out.println(teacher.getInfo());
        //Polymorphism
        Person p = new Student("王五", 20, "YY大学", "计算机");
        System.out.println(p.getInfo());


    }

}
