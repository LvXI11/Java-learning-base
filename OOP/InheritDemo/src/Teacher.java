public class Teacher extends Person{
    private String subject;
    private int workAge;

    public Teacher(String name,int age,String subject,int workAge){
        super(name,age);
        this.subject = subject;
        this.workAge = workAge;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
    public String getInfo(){
        return super.getInfo()+" 学科："+getSubject()+" 工龄："+getWorkAge();
    }
}
