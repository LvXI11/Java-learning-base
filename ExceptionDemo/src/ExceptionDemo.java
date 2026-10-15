
import java.util.Scanner;

public class ExceptionDemo {

    public void test(){
//        divide(10, 0);java.lang.ArithmeticException: / by zero
        try {
            System.out.println(divide(10, 0));
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("程序结束");
        }
    }

    static int divide(int a, int b){
        return a / b;
    }

    @SuppressWarnings("finally")
    static int testFinally(int a, int b){
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 2;
        }finally {
            return 3;
        }
    }
    @SuppressWarnings("finally")
    static int testFinally2(int a, int b){
        try {
            System.out.println("try");
            System.out.println("try2");
            return 1;
        } finally {
            System.out.println("finally");
            return 2;
        }
    }

    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();
        demo.test();
        System.out.println();
        System.out.println(testFinally(10, 0));
        System.out.println();
        System.out.println(testFinally2(10, 0));


        try {
            int[] arr = new int[3];
            arr[5] = 1;
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
            System.out.println();
            System.out.println();
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
//        Exception 'java.lang.IndexOutOfBoundsException' has already been caught

    }
}
