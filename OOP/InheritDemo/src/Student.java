public class Student extends Person{
    private String school;
    private String major;

    public Student(String name,int age,String school,String major){
        super(name,age);
        this.school = school;
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInfo(){
        return super.getInfo()+" 学校："+getSchool()+" 专业："+getMajor();
    }
}
