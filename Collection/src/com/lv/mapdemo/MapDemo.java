package com.lv.mapdemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    @Test//增删查改
    public void test(){
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.put("张三", 90));
        System.out.println(map.put("李四", 85));
        System.out.println(map);
        System.out.println(map.put("张三", 95));
        System.out.println(map);

        System.out.println("size = " + map.size());

        System.out.println("get(张三) = " + map.get("张三"));
        System.out.println("get(王五) = " + map.get("王五"));
        System.out.println("containsKey(李四) = " + map.containsKey("李四"));
        System.out.println("containsValue(90) = " + map.containsValue(90));
        System.out.println("containsValue(95) = " + map.containsValue(95));

        System.out.println("remove(李四) = " + map.remove("李四"));
        System.out.println("remove(李四) = " + map.remove("李四"));
        System.out.println("size = " + map.size());
    }

    @Test//遍历
    public void test2(){
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 90);
        map.put("李四", 85);
        //方式1：不推荐，效率低
        for(String k : map.keySet()) {
            System.out.println(k + " = " + map.get(k));
        }

        System.out.println();
        //方式2
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        //方式3
        for(Integer v : map.values()) {
            System.out.println(v);
        }

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getKey().equals("李四")) {
                e.setValue(100);
            }
        }
        System.out.println(map);
    }
}
