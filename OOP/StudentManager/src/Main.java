public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.setName("张三"); s1.setAge(12); s1.setScore(62.2);
        s2.setName("李四"); s2.setAge(18); s2.setScore(61.5);
        s3.setName("王五"); s3.setAge(101); s3.setScore(90);

        StudentManager test = new StudentManager();
        test.addStudent(s1);//添加学生
        test.addStudent(s2);
        test.addStudent(s3);
        test.printAll();//打印学生
        System.out.println("平均成绩是：" + test.AverageScore());
        test.topStudet();
        test.sortByScoreDesc();
        test.printAll();
        Student found = test.findByName("张三");
        if (found != null) found.printInfo(); else System.out.println("没找到");
        if(test.removeStudentByName("李四")) System.out.println("删除成功");
        else System.out.println("删除失败");
        test.printAll();//打印学生
    }
}
