

public class StudentManager {

    private Student students[] = new Student[5];
    private int count = 0;

    public Student buildStudent(String name,int age,double score){
        if(count == students.length) return null;
        Student newstu = new Student();
        newstu.setName(name);
        newstu.setAge(age);
        newstu.setScore(score);
        return newstu;
    }
    public void addStudent(Student s){
            students[count++] = s;
            System.out.println("添加成功");
    }
    public Student findByName(String name){
        for (int i = 0; i < count; i++) {
            if(students[i].getName().equals(name))
                return students[i];
        }
        return null;
    }
    public boolean removeStudentByName(String name){
        int index;
        for (int i = 0; i < count; i++) {
            if(students[i].getName().equals(name)){
                index = i;
                for(int j = index;j < count-1; j++){
                    students[j] = students[j+1];
                }
                count--;
                return true;
            }
        }
        return false;
    }
    public void printAll(){
        System.out.println("---学生列表---");
        for (int i = 0; i < count; i++) {
            System.out.println("name="+students[i].getName()+
                    ",age="+students[i].getAge()+",score="+students[i].getScore());
        }
    }
    public double AverageScore(){
        if(count == 0) return 0;
       return TotaleScore()/count;
    }
    public double TotaleScore(){
        if(count == 0) return 0;
        else{
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += students[i].getScore();
            }
            return total;
        }
    }
    public void topStudet(){
        if(count == 0) return;
        int maxindex = 0;
        for (int i = 0; i < count; i++) {
            if(students[maxindex].getScore() < students[i].getScore())
                maxindex =i;
        }
        System.out.print("最高分的学生是:"+students[maxindex].getName()+"  ");
        students[maxindex].printInfo();
    }
    public void sortByScoreDesc(){
        for (int i = 0; i < count-1; i++) {
            for(int j = 0;j < count-i-1; j++){
                if(students[j].getScore() < students[j+1].getScore()){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
    }
    public boolean isFull(){
        if(count == students.length) return true;
        else return false;
    }
}
