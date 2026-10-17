import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入今天星期几：");
        int week=sc.nextInt();
        System.out.print("请输入预测的天数：");
        int afday=sc.nextInt();
        week += afday;
        week %= 7;
        System.out.println(afday+"天后是星期"+(week==0?"日":week));
    }
}
