import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Customer {
    private String name;
    private List<Account> accounts;
    private int allNum;              // 已开户数量（账户序号）

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllNum() {
        return allNum;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // ================= 业务方法（方法名沿用你原来的）=================

    /** 开新账户：成功返回卡号，密码不合法返回 -1 */
    public long buildAccount(String password) {
        if (!validPassword(password)) return -1;

        Random random = new Random();
        long cardId;
        do {
            cardId = random.nextLong(10000000000L, 99999999999L);
        } while (searchAccount(cardId) != null);          // 卡号查重

        accounts.add(new Account(name, cardId, password, 0, ++allNum));
        return cardId;
    }

    /** 按卡号找账户：找不到返回 null（★ 修掉原来"返回最后一个元素"的 bug） */
    public Account searchAccount(long id) {
        for (Account a : accounts) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    /** 打印名下所有账户；有账户返回 true */
    public boolean findAllAccounts() {
        if (accounts.isEmpty()) return false;
        System.out.println(name + " 名下所有账户：");
        for (Account a : accounts) {
            System.out.println(a);
        }
        return true;
    }

    /** 取款：成功 true（失败原因由 Menu 层提示） */
    public boolean takeMoney(long id, double num) {
        Account account = searchAccount(id);
        if (account == null) return false;
        if (num <= 0) return false;
        if (account.getMoney() < num) return false;

        account.setMoney(account.getMoney() - num);
        return true;
    }

    /** 存款：返回存入金额；账户不存在或选项错误返回 -1 */
    public int saveMoney(long id, int choice) {
        Account account = searchAccount(id);
        if (account == null) return -1;

        int addMoney;
        switch (choice) {
            case 1: addMoney = 100;   break;
            case 2: addMoney = 200;   break;
            case 3: addMoney = 500;   break;
            case 4: addMoney = 1000;  break;
            case 5: addMoney = 2000;  break;
            case 6: addMoney = 5000;  break;
            case 7: addMoney = 10000; break;
            default: return -1;
        }

        account.setMoney(account.getMoney() + addMoney);
        return addMoney;
    }

    /** 查余额：密码正确则打印账户信息并返回 true */
    public boolean search(long id, String password) {
        Account account = searchAccount(id);
        if (account == null) return false;
        if (!password.equals(account.getPassword())) return false;

        System.out.println("所属银行: " + account.getName());
        System.out.println("用户姓名: " + name);
        System.out.println("用户账户: " + account.getId());
        System.out.println("用户余额: " + account.getMoney());
        return true;
    }

    /** 改密码：账户存在且新密码合法返回 true（旧密码校验在 Menu 层做） */
    public boolean changePassword(long id, String password) {
        Account account = searchAccount(id);
        if (account == null) return false;
        if (!validPassword(password)) return false;

        account.setPassword(password);
        return true;
    }

    /** 所有账户余额合计 */
    public double sum() {
        double sum = 0;
        for (Account a : accounts) {
            sum += a.getMoney();
        }
        return sum;
    }

    /** 按余额由多到少打印（Account.compareTo 已是降序） */
    public void sort() {
        Collections.sort(accounts);
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    /** 密码规则：非空，且只含字母数字（原来抄了 3 遍，抽成一个方法） */
    private boolean validPassword(String password) {
        if (password == null || password.isEmpty()) return false;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) return false;
        }
        return true;
    }
}
