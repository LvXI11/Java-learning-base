public class PolymorphismTest {

    public static void main(String[] args) {

        Person[] people = {new Student("zhangsan",22,"dongqu","software"),
                            new Teacher("laoli",45,"chinese",21),
                            new Person("meili",66)};

        for(Person p : people){
            System.out.println(p.getInfo());
        }

        //向下转型
        printSchool(people[0]);//dongqu
        printSchool(people[1]);//error

        //为什么打印出来是Person
//        System.out.println("***********");
//        Person p = new Student("wangwu",33,"hhhhh","jisuanji");
//        System.out.println(p.tag);
    }

    public static void printSchool(Person p){
        System.out.println("------------------------");
        if(p instanceof Student s){
            System.out.println("学校："+s.getSchool());
        }else{
            System.out.println("不是学生");
        }
    }
}
