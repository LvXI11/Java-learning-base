import java.util.List;
import java.util.Scanner;

public class InputUtility {
    static int getInt(String stdin) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true) {
            System.out.print(stdin);
            try {
                number = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误（请输入整数）");
                scanner.nextLine();
            }
        }
        return number;
    }

    static double getDouble(String stdin) {
        Scanner scanner = new Scanner(System.in);
        double number;
        while(true) {
            System.out.println(stdin);
            try {
                number = Double.parseDouble(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误（请输入数字)");
                scanner.nextLine();
            }
        }
        return number;
    }

    static long getLong(String stdin) {
        Scanner scanner = new Scanner(System.in);
        long number;
        while(true) {
            System.out.print(stdin);
            try {
                number = Long.parseLong(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误（请输入整数）");
                scanner.nextLine();
            }
        }
        return number;
    }

    static Customer inputName(List<Customer> customers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名:");
        Customer customer = null;
        for(Customer c : customers) {
            if(c.getName().equals(scanner.next())) {
                customer = c;
                break;
            }
        }
        return customer;
    }
}
