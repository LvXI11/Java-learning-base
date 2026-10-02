
import java.util.Scanner;

public class RecursionDemo {
    static int factorial(int n){//阶乘
        if(n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }

    static  int sumTo(int n){//1~n总和
        if(n == 0) return 0;
        return n+sumTo(n-1);
    }

    static int fib(int n){//斐波那契
        if( n == 0) return 0;
        if(n == 1) return 1;
        return fib(n -1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入数字：");
        int n = scanner.nextInt();
        System.out.println(n+"的阶乘："+factorial(n));
        System.out.println("1到"+n+"的总和：" + sumTo(n));
        System.out.println("n为" + n + "的斐波那契："+fib(n));
    }
}
