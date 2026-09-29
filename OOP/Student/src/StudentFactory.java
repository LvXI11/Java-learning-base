public class StudentFactory {
    public static Student createStudent(String name,int age){
        Student s = new Student();
        s.setName(name);
        s.age = age;
        return s;
    }

    public static void main(String[] args) {
        Student s4 = createStudent("Helen",12);
        s4.printInfo();
        Student s5 = createStudent("Jack",65);
        s5.printInfo();
    }
}
