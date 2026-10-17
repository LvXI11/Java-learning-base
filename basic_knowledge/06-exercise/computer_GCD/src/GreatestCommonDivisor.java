import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("输入两个整数：");
        int a=sc.nextInt();
        int b=sc.nextInt();
        while (b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        System.out.println("最大公约数：" + a);
    }
}
