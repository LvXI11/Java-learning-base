public class InheritTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setAge(17);
        student.setMajor("软件工程");
        student.setSchool("成人大学");
        System.out.println(student.getInfo());

        Teacher teacher = new Teacher();
        teacher.setName("老李");
        teacher.setAge(54);
        teacher.setSubject("物理");
        teacher.setWorkAge(23);
        System.out.println(teacher.getInfo());
        Person p = new Student("王五", 20, "YY大学", "计算机");
        System.out.println(p.getInfo());
    }
}
