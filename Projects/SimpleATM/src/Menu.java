import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        System.out.println("----- 建设银行 -----");

        while(true) {

            System.out.println("欢迎使用ATM!");
            System.out.println();
            System.out.print("请输入你的姓名:");
            String name = scanner.next();
            boolean foundCustomer = false;
            for(Customer customer : customers) {
                if(customer.getName().equals(name)) {
                    foundCustomer = true;
                    break;
                }
            }

            if(!foundCustomer) {
                System.out.println("你还未在本行记录个人信息");
                System.out.println("0.注册");
                System.out.println("1.不注册");
                int selection = InputUtility.getInt("请选择：");
                switch (selection) {
                    case 0:
                        System.out.print("请输入姓名:");
                        customers.add(new Customer(scanner.next()));
                        break;
                    case 1:
                        continue;
                    default:
                        System.out.println("输入错误");
                }
            }

            while(true) {
                System.out.println();
                System.out.println("1.注册账户");
                System.out.println("2.查看名下账户");
                System.out.println("3.存钱");
                System.out.println("4.取钱");
                System.out.println("5.查看账户余额");
                System.out.println("6.查看所以账户总余额");
                System.out.println("7.修改账户密码");
                System.out.println("0.退出");

                int function =  InputUtility.getInt("请选择功能:");
                Customer customer = null;
                long cardId;
                Account account = null;
                String password = null;

                switch (function) {
                    case 1:
                        customer = InputUtility.inputName(customers);
                        if(customer == null) {
                            System.out.println("姓名输入错误");
                            continue;
                        }
                        System.out.print("请输入密码：");
                        if((cardId = customer.buildAccount(scanner.next())) != -1) {
                            System.out.println("注册成功" + " 卡号：" + cardId);
                        } else {
                            System.out.println("注册失败");
                        }
                        break;
                    case 2:
                        customer = InputUtility.inputName(customers);
                        if(customer == null) {
                            System.out.println("姓名输入错误");
                            continue;
                        }
                        if(!customer.findAllAccounts()) {
                            System.out.println("名下无任何账户");
                        }
                        break;
                    case 3:
                        customer = InputUtility.inputName(customers);
                        if(customer == null) {
                            System.out.println("姓名输入错误");
                            continue;
                        }
                        cardId = InputUtility.getLong("请输入卡号：");
                        account = customer.searchAccount(cardId);
                        if(account == null) {
                            System.out.println("未找到账户");
                            continue;
                        }
                        System.out.print("请输入密码：");
                        password = scanner.next();
                        if(!account.getPassword().equals(password)) {
                            System.out.println("密码错误!");
                            continue;
                        }
                        System.out.println("1. [100]    2. [200] ");
                        System.out.println("3. [500]    4. [1000] ");
                        System.out.println("5. [2000]   6. [5000] ");
                        System.out.println("7. [10000]");

                        int amountSelection = InputUtility.getInt("请选择存款金额：");
                        int amount;
                        if((amount = customer.saveMoney(cardId, amountSelection)) != -1) {
                            System.out.println("存款成功，存款金额为" + amount);
                        } else {
                            System.out.println("存款失败");
                        }
                        break;
                    case 4:
                }
            }
        }
    }
}
