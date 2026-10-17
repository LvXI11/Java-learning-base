import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入月份：");
        int month=sc.nextInt();
        switch(month){
            case 1: case 2: case 3:System.out.println("Spring");break;
            case 4: case 5: case 6:System.out.println("Summer");break;
            case 7: case 8: case 9:System.out.println("Autumn");break;
            case 10: case 11: case 12:System.out.println("Winter");break;
            default:System.out.println("输入错误，已退出");
        }
    }
}
