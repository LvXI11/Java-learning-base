import java.util.Scanner;

public class SortStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生人数：");
        int n = sc.nextInt();
        double [] score = new double[n];
        System.out.printf("请输入%d个成绩",n);
        double max=-1;
        for (int i = 0; i < score.length; i++) {
            double num = sc.nextDouble();
            if(max<num)max=num;
            score[i] = num;
        }
        System.out.printf("最高分是%.1f%n",max);
        for (int i = 0; i < score.length; i++) {
            System.out.printf("student0 score is %.1f grade is ",score[i]);
            if(score[i]>=max-10) System.out.println('A');
            else if(score[i]>=max-20&&score[i]<max-10) System.out.println('B');
            else if(score[i]>=max-30&&score[i]<max-20) System.out.println('C');
            else System.out.println('D');
        }
    }
}
