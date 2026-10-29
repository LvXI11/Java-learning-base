package com.lv.compareapi;

import java.util.*;

public class SortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(new Student("LiMing", 88),
                new Student("WangFang", 95), new Student("ZhangWei", 88),
                new Student("ZhaoMin", 72), new Student("ChenChen", 95)));

        System.out.print("原始  : ");
        for(Student s : list) {
            System.out.print(s.getName() + " " + s.getScore() + " | ");
        }

        Collections.sort(list);
        System.out.println();
        System.out.print("Comparable (分数降序，稳定)    : ");
        for(Student s : list) {
            System.out.print(s.getName() + " " + s.getScore() + " | ");
        }

        Comparator<Student> comparator = new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1 == s2) return 0;
                int value = -Integer.compare(s1.getScore(), s2.getScore());
                if(value == 0) {
                    return s1.getName().compareTo(s2.getName());
                }
                return value;
            }
        };

        list.sort(comparator);
        System.out.println();
        System.out.print("Comparator (分数降序->名字升序) : ");
        for(Student s : list) {
            System.out.print(s.getName() + " " + s.getScore() + " | ");
        }
    }
}
