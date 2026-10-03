public class Student_Test {
//    static void change1(Student x){
//        x.setName("haha");
//    }
//
//    static void change2(Student x){
//        x = new Student();
//        x.setName("666");
//        System.out.println(x.name);
//    }
//
//    static void modify(int x) {x = 999;}
//    static void modfiyStudent(Student s) {s.setName("Bob");}
//    static void reassign(Student s) {s = new Student(); s.setName("Mary");}

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.setName("张三"); s1.setAge(12); s1.setScore(62.2);
        s2.setName("李四"); s2.setAge(18); s2.setScore(61.5);
        s3.setName("王五"); s3.setAge(101); s3.setScore(90);
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
//        System.out.println("------------------");
//        change1(s1);
//        s1.printInfo();
//        change2(s1);
//        s1.printInfo();
//        System.out.println("---------------------");
//        int x=0;
//        System.out.println("x="+x);
//        modify(x);
//        System.out.println("x="+x);
//        modfiyStudent(s3);
//        s3.printInfo();
//        reassign(s2);
//        s2.printInfo();
    }
}
