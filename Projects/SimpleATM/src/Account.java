import java.util.Objects;

public class Account implements Comparable<Account>{
    private String name;
    private long id;
    private double money;
    private String password;
    private int selfNum;

    public Account(String name, long id, String password, double money, int selfNum) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.money = money;
        this.selfNum = selfNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSelfNum() {
        return selfNum;
    }

    public void setSelfNum(int selfNum) {
        this.selfNum = selfNum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        return id == account.id && selfNum == account.selfNum && Objects.equals(name, account.name);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", money=" + money +
                ", selfNum=" + selfNum +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Long.hashCode(id);
        result = 31 * result + selfNum;
        return result;
    }

    @Override
    public int compareTo(Account o) {
        return -Double.compare(this.getMoney(), o.getMoney());
    }

}
