import java.util.List;

public class Menu {
    public static void main(String[] args) {
        List<Customer> customers = DataStore.load();
        System.out.println("----- 建设银行 -----");

        while (true) {
            // ================= 第 1 层：登录 =================
            System.out.println();
            String name = InputUtility.getString("请输入你的姓名(输入 exit 退出): ");
            if ("exit".equalsIgnoreCase(name)) {
                System.out.println("再见");
                return;
            }

            Customer current = InputUtility.findCustomer(customers, name);
            if (current == null) {
                System.out.println("你还未在本行记录个人信息");
                if (InputUtility.getInt("0.注册  1.不注册: ") == 1) continue;
                current = new Customer(InputUtility.getString("请输入姓名: "));
                customers.add(current);
                DataStore.save(customers);
                System.out.println("注册成功，欢迎 " + current.getName());
            }

            // ================= 第 2 层：操作 =================
            boolean logout = false;
            while (!logout) {
                printMenu();
                switch (InputUtility.getInt("请选择功能: ")) {
                    case 1:  openAccount(current);    DataStore.save(customers); break;
                    case 2:  listAccounts(current);   break;
                    case 3:  saveMoney(current);      DataStore.save(customers); break;
                    case 4:  takeMoney(current);      DataStore.save(customers); break;
                    case 5:  queryBalance(current);   break;
                    case 6:  totalBalance(current);   break;
                    case 7:  changePassword(current); DataStore.save(customers); break;
                    case 0:  logout = true;           break;
                    default: System.out.println("输入错误，请重新选择");
                }
            }
            System.out.println("已退出登录");
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1.注册账户        2.查看名下账户");
        System.out.println("3.存钱            4.取钱");
        System.out.println("5.查看账户余额    6.查看所有账户总余额");
        System.out.println("7.修改账户密码    0.退出");
    }

    // ================= 8 个功能： =================

    private static void openAccount(Customer current) {
        String pwd = InputUtility.getString("请设置新账户的密码(字母+数字): ");
        long cardId = current.buildAccount(pwd);
        if (cardId == -1) {
            System.out.println("开户失败：密码格式不对（只能字母和数字）");
        } else {
            System.out.println("开户成功，卡号：" + cardId + " （请记住）");
        }
    }

    private static void listAccounts(Customer current) {
        if (!current.findAllAccounts()) {
            System.out.println("名下无任何账户");
        }
    }

    private static void saveMoney(Customer current) {
        Account acc = askAccountWithPassword(current);
        if (acc == null) return;

        System.out.println("1.[100]   2.[200]   3.[500]   4.[1000]");
        System.out.println("5.[2000]  6.[5000]  7.[10000]");
        int amount = current.saveMoney(acc.getId(), InputUtility.getInt("请选择存款金额: "));
        if (amount == -1) {
            System.out.println("存款失败：金额选项错误");
        } else {
            System.out.println("存款成功，存入 " + amount + "，当前余额 " + acc.getMoney());
        }
    }

    private static void takeMoney(Customer current) {
        Account acc = askAccountWithPassword(current);
        if (acc == null) return;

        double amount = InputUtility.getDouble("请输入取款金额: ");
        if (amount <= 0) {
            System.out.println("取款金额必须大于 0");
            return;
        }
        if (current.takeMoney(acc.getId(), amount)) {
            System.out.println("取款成功，当前余额 " + acc.getMoney());
        } else {
            System.out.println("取款失败：余额不足（当前余额 " + acc.getMoney() + "）");
        }
    }

    private static void queryBalance(Customer current) {
        long cardId = InputUtility.getLong("请输入卡号: ");
        String pwd = InputUtility.getString("请输入密码: ");
        if (!current.search(cardId, pwd)) {
            System.out.println("查询失败：账户不存在或密码错误");
        }
    }

    private static void totalBalance(Customer current) {
        System.out.println("账户数：" + current.getAccounts().size());
        System.out.println("总余额：" + current.sum());
        if (!current.getAccounts().isEmpty()) {
            System.out.println("按余额由多到少：");
            current.sort();
        }
    }

    private static void changePassword(Customer current) {
        Account acc = askAccountWithPassword(current);
        if (acc == null) return;

        String newPwd = InputUtility.getString("请输入新密码(字母+数字): ");
        if (current.changePassword(acc.getId(), newPwd)) {
            System.out.println("修改密码成功");
        } else {
            System.out.println("修改失败：密码格式不对（只能字母和数字）");
        }
    }

    /** 公共四步：问卡号 -> 找账户 -> 问密码 -> 校验；任一步失败返回 null */
    private static Account askAccountWithPassword(Customer current) {
        long cardId = InputUtility.getLong("请输入卡号: ");
        Account acc = current.searchAccount(cardId);
        if (acc == null) {
            System.out.println("未找到账户");
            return null;
        }
        String pwd = InputUtility.getString("请输入密码: ");
        if (!acc.getPassword().equals(pwd)) {
            System.out.println("密码错误");
            return null;
        }
        return acc;
    }
}
