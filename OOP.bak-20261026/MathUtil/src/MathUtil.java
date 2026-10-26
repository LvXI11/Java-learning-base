import java.util.Scanner;

public class MathUtil {
    static int sum3(int a,int b,int c) {return a+b+c;}

    static double average(int a,int b,int c){
        return (double)sum3(a,b,c)/3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个整数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("a+b+c="+sum3(a,b,c));
        System.out.println("average:"+average(a,b,c));
    }
}
