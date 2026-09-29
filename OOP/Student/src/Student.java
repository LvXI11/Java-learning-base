public class Student {
    String name;
    int age;
    double score;
    public void printInfo(){
        System.out.println("姓名："+getName()+"年龄："+age+" 分数："+score+
                " isAdult;"+isAdult());
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public boolean isAdult(){
        return age >= 18;
    }
}
