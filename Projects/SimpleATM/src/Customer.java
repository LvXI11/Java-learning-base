import java.text.Format;
import java.text.Normalizer;
import java.util.*;

public class Customer {
    private String name;
    private List<Account> accounts;
    private  int allNum;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getAllNum() {
        return allNum;
    }

    public  void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account searchAccount(long id) {
        Iterator<Account> iterator = accounts.iterator();
        Account account = null;
        while(iterator.hasNext()) {
            if((account = iterator.next()).getId() == id) {
                break;
            }
        }
        return account;
    }

    public long buildAccount(String password) {
        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLetterOrDigit(password.charAt(i))) {
                System.out.println("密码格式不对，应是（字母+ 数字）");
                return -1;
            }
        }
        Random random = new Random();
        long value = random.nextLong(10000000000L, 99999999999L);
        accounts.add(new Account(name, value, password, 0 , ++allNum));
        return value;
    }

    public boolean findAllAccounts() {
        System.out.println(name + "名下所以账户:");
        boolean hasAccount = false;
        for(Account account : accounts) {
            hasAccount = true;
            System.out.println(account);
        }
        return hasAccount;
    }
    public boolean takeMoney(long id, double num) {
        Account account = searchAccount(id);
        if(account == null) {
            System.out.println("未找到账户");
            return false;
        }
        if(num > account.getMoney()) {
            System.out.println("余额不足");
            return false;
        }

        account.setMoney(account.getMoney() - num);
        return true;
    }

    public int saveMoney(long id, int choice) {
        Account account = searchAccount(id);
        int addMoney = 0;
        switch (choice) {
            case 1: addMoney = 100;break;
            case 2: addMoney = 200;break;
            case 3: addMoney = 500;break;
            case 4: addMoney = 1000;break;
            case 5: addMoney = 2000;break;
            case 6: addMoney = 5000;break;
            case 7: addMoney = 10000;break;
            default:
                System.out.println("选择错误");
                return -1;
        }
        account.setMoney(account.getMoney() + addMoney);
        return addMoney;
    }

    public boolean search(long id, String password) {
        Account account = searchAccount(id);
        if(account == null) {
            System.out.println("未找到账户");
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLetterOrDigit(password.charAt(i))) {
                System.out.println("密码格式不对，应是（字母+ 数字）");
                return false;
            }
        }
        if(password.equals(account.getPassword())) {
            System.out.println("所属银行: " + account.getName());
            System.out.println("用户姓名: " + name);
            System.out.println("用户账户: " + account.getId());
            System.out.println("用户余额: " + account.getMoney());
            return true;
        } else {
            System.out.println("密码错误");
        }
        return false;
    }

    public boolean changePassword(long id, String password) {
        Account account = searchAccount(id);
        if(account == null) {
            System.out.println("未找到账户");
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLetterOrDigit(password.charAt(i))) {
                System.out.println("密码格式不对，应是（字母+ 数字）");
                return false;
            }
        }
        account.setPassword(password);
        return true;
    }

    //计算所以账户的总余额
    public double sum() {
        Iterator<Account> iterator = accounts.iterator();
        double sum = 0;
        while(iterator.hasNext()) {
            sum += iterator.next().getMoney();
        }
        return sum;
    }

    //按余额由多到少的顺序依次打印出来
    public void sort() {
        Collections.sort(accounts);
        for(Account account : accounts) {
            System.out.println(account);
        }
    }
}
