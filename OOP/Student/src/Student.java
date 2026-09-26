public class Student {
    String name;
    int age;
    double score;
    public void printInfo(){
        System.out.println("姓名："+getName()+"年龄："+age+" 分数："+score);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
