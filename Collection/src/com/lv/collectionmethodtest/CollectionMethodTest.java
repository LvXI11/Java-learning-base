package com.lv.collectionmethodtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionMethodTest {
    @Test//add() /addAll()
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("add 之后: " + list + "  size = " +list.size());

        List<String> other = new ArrayList<>();
        other.add("D");
        other.add("E");

        boolean changed = list.addAll(other);
        System.out.println("addAll 之后: " + list  + "  size = " + list.size() + " 返回值= " + changed);

    }

    @Test//remove()
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("add 之后: " + list + "  size = " +list.size());

        boolean removed = list.remove("C");
        System.out.println(list + "返回= " + removed);

        String gone = list.remove(0);
        System.out.println(list + "返回= " + gone);
    }

    @Test//removeAll()
    public void test2(){
        List<String> list = new ArrayList<>(List.of("A","B","C","D","E"));
        List<String> other = new ArrayList<>(List.of("C","E"));

        boolean changed = list.removeAll(other);
        System.out.println("removeAll之后：" + list + "size=" + list.size() + " 返回=" + changed);
    }

    @Test//retainAll()
    public void test3(){
        List<String> list = new ArrayList<>(List.of("A","B","C","D","E"));
        List<String> other = new ArrayList<>(List.of("C","E"));

        boolean changed = list.retainAll(other);
        System.out.println("retainAll之后：" + list + "size=" + list.size() + " 返回=" + changed);
    }

    @Test//contain()
    public void test4(){
        List<String> list = new ArrayList<>(List.of("A","B","C"));

        System.out.println("contains(\"B\") = " + list.contains("B") + list);//true
        System.out.println("contains(\"Z\") = " + list.contains("Z") + list);//false
        System.out.println("contains([A,C]) = " + list.containsAll(List.of("A","C")));//true
        System.out.println("contains([A,Z]) = " + list.containsAll(List.of("A","Z")));//false
    }

    @Test//size() isEmpty() clear()
    public void test5(){
        List<String> list = new ArrayList<>(List.of("A","B","C"));

        System.out.println(list);
        System.out.println("size = " + list.size());
        System.out.println("isEmpty(清空之前) = " + list.isEmpty());
        list.clear();
        System.out.println("clear 之后：" + list + " size=" + list.size() + " isEmpty=" + list.isEmpty());
    }

    @Test//Iterator
    public void test6(){
        List<String> list = new ArrayList<>(List.of("A","B","C"));

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            String s = it2.next();
            if(s.equals("A")) {//ConcurrentModificationException
                list.remove("A");
            }
        }
        System.out.println(list);

        Iterator<String> it3 = list.iterator();
        while (it3.hasNext()) {
            String s = it3.next();
            if(s.equals("C")) {
                it3.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test7(){
        List<String> list = new ArrayList<>(List.of("A","B","C"));

        Object[] arr1 = list.toArray();
        String[] arr2 = list.toArray(new String[0]);

        System.out.println("arr1 = " + java.util.Arrays.toString(arr1) +
                "类型 = " + arr1.getClass().getSimpleName());
        System.out.println("arr2 = " + java.util.Arrays.toString(arr2) +
                "类型 = " + arr2.getClass().getSimpleName());
    }

    @Test
    public void test8(){
        List<String> a = new ArrayList<>(List.of("A","B","C"));
        List<String> b = new ArrayList<>(List.of("A","B","C"));
        List<String> c = new ArrayList<>(List.of("C","B","A"));

        System.out.println("a == b          :" + (a == b));
        System.out.println("a.equals(b)     :" + a.equals(b));
        System.out.println("a.equals(c)     :" + a.equals(c));
        System.out.println("a.hashCode()    :" + a.hashCode());
        System.out.println("b.hashCode()    :" + b.hashCode());
        System.out.println("c.hashCode()    :" + c.hashCode());
    }
}
