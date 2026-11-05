package com.lv.api.stream.convert;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo {
    public static void main(String[] args) throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");
        File gf = new File(tmp, "gbk.txt");

        try(Writer w = new OutputStreamWriter(new FileOutputStream(gf), Charset.forName("GBK"))) {
            w.write("中文测试ABC");
        }
        System.out.println("文件大小 = " + gf.length() + " 字节");

        System.out.println("UTF-8 读 GBK 文件 : ");
        try(Reader r = new FileReader(gf)) {
            int c;
            while((c = r.read()) != -1) System.out.print((char)c);
        }
        System.out.println();

        System.out.println("GBK  读 GBK 文件 : ");
        try(Reader r = new InputStreamReader(new FileInputStream(gf), Charset.forName("gbk"))) {
            int c;
            while((c = r.read()) != -1) System.out.print((char)c);
        }
        System.out.println();
    }
}
