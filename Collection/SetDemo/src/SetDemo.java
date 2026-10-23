import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    @Test
    public void test(){
        Set<String> h = new HashSet<>();
        h.add("A");
        h.add("B");
        h.add("A");
        h.add("C");
        h.add("B");
        h.add("D");
        System.out.println(h + "size = " + h.size());//[A, B, C, D]size = 4
    }

    @Test
    public void test2(){
        Set<String> l = new LinkedHashSet<>();
        l.add("A");
        l.add("B");
        l.add("A");
        l.add("C");
        l.add("B");
        l.add("D");
        System.out.println(l + "size = " + l.size());//[A, B, C, D]size = 4
    }

    @Test
    public void test3(){
        Set<String> t = new TreeSet<>();
        t.add("A");
        t.add("B");
        t.add("A");
        t.add("C");
        t.add("B");
        t.add("D");
        System.out.println(t + "size = " + t.size());//[A, B, C, D]size = 4
    }

    @Test
    public void test4(){
        Set<Integer> h = new HashSet<>();
        h.add(100); h.add(1); h.add(50); h.add(20); h.add(3);
        System.out.println(h);
    }
    @Test
    public void test5(){
        Set<Integer> l = new LinkedHashSet<>();
        l.add(100); l.add(1); l.add(50); l.add(20); l.add(3);
        System.out.println(l);
    }

    @Test
    public void test6(){
        Set<Integer> t = new TreeSet<>();
        t.add(100); t.add(1); t.add(50); t.add(20); t.add(3);
        System.out.println(t);
    }
}
