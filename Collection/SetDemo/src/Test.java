import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("张三", 10));
        set.add(new Student("张三", 10));
        System.out.println("size = " + set.size());
    }
}
