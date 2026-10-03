public class StudentManager {
    private Student students[] = new Student[5];
    private int count = 0;

    public void addStudent(Student s){
        if(count < students.length){
            students[count++] = s;
        }
        else System.out.println("成员已满，不可添加");
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
        else{
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += students[i].getScore();
            }
            return total/count;
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
}
