import java.util.List;
import java.util.Scanner;

public class InputUtility {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtility() { }          // 工具类，不许 new

    static int getInt(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Integer.parseInt(SCANNER.next());
            } catch (NumberFormatException e) {
                System.out.println("输入错误（请输入整数）");
                SCANNER.nextLine();
            }
        }
    }

    static long getLong(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Long.parseLong(SCANNER.next());
            } catch (NumberFormatException e) {
                System.out.println("输入错误（请输入整数）");
                SCANNER.nextLine();
            }
        }
    }

    static double getDouble(String tip) {
        while (true) {
            System.out.print(tip);
            try {
                return Double.parseDouble(SCANNER.next());
            } catch (NumberFormatException e) {
                System.out.println("输入错误（请输入数字）");
                SCANNER.nextLine();
            }
        }
    }

    static String getString(String tip) {
        System.out.print(tip);
        return SCANNER.next();
    }

    /** 按姓名找客户，找不到返回 null */
    static Customer findCustomer(List<Customer> customers, String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }
}
