package com.lv.genericdemo;

import org.junit.Test;

public class Box<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static <T> void printArray(T[] arr) {
        for(T t : arr) {
            System.out.println(t);
        }
    }
    @Test
    public void test(){
        Box<String> box = new Box<>();
        box.setContent("学习");
        Box<Integer> box1 = new Box<>();
        box1.setContent(44);
        System.out.println(box.getContent());
        System.out.println(box1.getContent());
        System.out.println();

        Integer[] integers = new Integer[]{33,2,23,43,6};
        String[] strings = new String[]{"helen", "nnnn"};
        Box.printArray(integers);
        Box.printArray(strings);
    }
}
