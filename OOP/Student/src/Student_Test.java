public class Student_Test {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.setName("张三"); s1.age=12; s1.score=62.2;
        s2.setName("李四"); s2.age=12; s2.score=61.5;
        s3.setName("王五"); s3.age=11; s3.score=90;

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
    }
}
