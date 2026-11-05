package com.lv.api.fileclass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        String dirPath = "D:\\file\\dsh-workspace-directory\\LeetCode_problem_Java";

        System.out.println("=== (1) 实例化 ===");
        File a = new File(dirPath);
        File b = new File(a, "67.java");
        File c = new File(dirPath, "67.java");
        System.out.println("new File(String)        -> " + a.getPath());
        System.out.println("new File(File,String)   -> " + b.getPath());
        System.out.println("new File(String,String) -> " + c.getPath());

        System.out.println();
        System.out.println("=== (2) 判断 ===");
        System.out.println("a.exists()      =" + a.exists());
        System.out.println("a.isDirectory() =" + a.isDirectory());
        System.out.println("a.isFile()      =" + a.isFile());
        System.out.println("b.canRead()     =" + b.canRead());
        System.out.println("b.isHidden()    =" + b.isHidden());

        System.out.println();
        System.out.println("=== (3) 取属性 ===");
        System.out.println("b.getName()        =" + b.getName());
        System.out.println("b.getParent()      =" + b.getParent());
        System.out.println("b.getAbsolutePath()=" + b.getAbsolutePath());
        System.out.println("b.length()         =" + b.length());
        System.out.println("b.lastModified()   =" + new Date(b.lastModified()));

        System.out.println();
        System.out.println("=== (4) 创建 / 删除 ===");
        String base = System.getProperty("java.io.tmpdir") + "filetest";
        File deep = new File(base, "a/b");
        System.out.println("deep.mkdir()    =" + deep.mkdir());
        System.out.println("deep.mkdirs()    =" + deep.mkdirs());

        File t = new File(base, "t.txt");
        System.out.println("t.createNewFile() = " + t.createNewFile());
        System.out.println("t.exists()        = " + t.exists() + "t.length() = " + t.length() + "字节");

        System.out.println("t.delete()      = " + t.delete());
        System.out.println("base.delete()   = " + new File(base).delete());
        System.out.println("deep.delete()   = " + deep.delete());
        System.out.println("a.delete()      = "+ new File(base, "a").delete());
        System.out.println("base.delete()   = " + new File(base).delete());

        System.out.println();
        System.out.println("=== (5) 列目录 ===");
        String[] names = a.list();
        File[] files = a.listFiles();
        System.out.println("a.list()        -> " + (names == null ? "null" : names.length + " 个名字"));
        System.out.println("a.listFiles()   -> " + (files == null ? "null" : files.length + " 个File"));

        File bad = new File(dirPath, "!!!不存在");
        System.out.println("不存在目录.list()        -> " + (bad.list() == null ? "null" : "非null"));
        System.out.println("不存在目录.listFiles()   -> " + (bad.listFiles() == null ? "null" : "非null"));
//        System.out.println(base);

    }
}
