public class Student {
    private String name;
    private int age;
    private double score;

    public Student(){}
    public Student(String name, int age, double score){
        this.name =name;
        this.age = age;
        this.score = score;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        if(age < 0 ||age >= 121) System.out.println("输入数据错误");
        else this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setScore(double score){
        if(score < 0 || score > 100) System.out.println("输入数据错误");
        else this.score = score;
    }
    public double getScore(){
        return score;
    }

    public void printInfo(){
        System.out.println("姓名："+name+" 年龄："+age+" 分数："+score);
    }
}
