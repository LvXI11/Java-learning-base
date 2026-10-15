import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("请输入一个整数：");
                int n = scanner.nextInt();
                System.out.println("你的输入是：" + n);
                break;
            } catch (InputMismatchException e) {
                System.out.println("输入不合法，请重新输入");
                scanner.nextLine();
            }
        }
    }
}
