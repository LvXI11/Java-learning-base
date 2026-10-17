import java.util.Scanner;
public class Main {

    //输入当年月份和天数，输出是当年的第几天
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入月份：");
        int month=sc.nextInt();
        System.out.print("请输入天数：");
        int day=sc.nextInt();
        int sumDays=0;
        switch(month){
            case 12:sumDays +=30;
            case 11:sumDays +=31;
            case 10:sumDays +=30;
            case 9:sumDays +=31;
            case 8:sumDays +=31;
            case 7:sumDays +=30;
            case 6:sumDays +=31;
            case 5:sumDays +=30;
            case 4:sumDays +=31;
            case 3:sumDays +=27;//27:2月份的总天数
            case 2:sumDays +=31;//31:1月份的总天数
            case 1:sumDays +=day;break;
        }
        System.out.println("是今年的第"+sumDays+"天");
    }
}
