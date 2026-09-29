import java.util.Scanner;

public class Caculator {
    public static int add(int a,int b) {return a+b;}
    public static int sub(int a,int b) {return a-b;}
    public static int mul(int a,int b) {return a*b;}
    public static double div(int a,int b) {return (double)a/b;}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入人两个整数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a+b="+add(a,b));
        System.out.println("a-b="+sub(a,b));
        System.out.println("a*b="+mul(a,b));
        System.out.println("a/b="+div(a,b));
    }
}
