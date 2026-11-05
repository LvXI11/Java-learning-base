package com.lv.api.stream.object;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");
        File df = new File(tmp, "dog.ser");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(df))) {
            oos.writeObject(new Dog("旺财", 3, "这是临时数据"));
            oos.writeInt(2026);
        }
        System.out.println("文件大小 = " + df.length() + " 字节");

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(df))) {
            Dog d = (Dog) ois.readObject();
            int year = ois.readInt();
            System.out.println("名字=" + d.name + " 年龄=" + d.age +
                    " secret=" + d.secret + " year=" + year);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
