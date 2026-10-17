import java.security.PublicKey;

public class Fibonacci {
    public static void main(String[] args) {
//        循环求斐波那契数列
//        1 1 2 3 5 8
        int f1=1;
        int f2=1;
        for (int i = 0; i < 20; i++) {
            System.out.print(f1+" ");
             int f3=f1+f2;
             f1=f2;
             f2=f3;
        }
    }

