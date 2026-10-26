public class ToStringTest {
    public static void main(String[] args) {
        Student student = new Student("zhangsan",22);
        System.out.println(student);
        System.out.println(student.toString());

        Student student1 = new Student("lisi",33);
        Student student2 = new Student("lisi",33);
        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));
    }
}
