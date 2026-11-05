import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static final File FILE = new File("atm.dat");

    public DataStore() {
    }

    @SuppressWarnings("unchecked")
    public static List<Customer> load() {
        if(!FILE.exists()) {
            System.out.println("[存档] 没找到 atm.dat, 从空数据开始");
            return new ArrayList<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            return (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[存档] 读档失败 (可能类结构变了，删掉 atm.dat 重来" + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void save(List<Customer> customers) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(customers);
        }catch (IOException e) {
            System.out.println("[存档] 保存失败：" + e.getMessage());
        }
    }
}
