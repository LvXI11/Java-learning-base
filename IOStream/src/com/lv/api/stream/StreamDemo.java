package com.lv.api.stream;

import java.io.*;

public class StreamDemo {
    public static void main(String[] args) throws IOException{
      String tmp = System.getProperty("java.io.tmpdir");
      File src = new File(tmp, "abc.txt");

      try(Writer w = new FileWriter(src)) {
          w.write("Hello 你好 世界");
      }

        System.out.println("文件大小 = " + src.length() + " 字节");

      try(Reader reader = new FileReader(src)) {
          char[] ch = new char[5];
          int len;
          int round = 0;
          while((len = reader.read(ch)) != -1) {
              round++;
              System.out.print("[第" + round + "轮 len = "+ len + "] ");
              for(int i = 0;i < len; i++) {
                  System.out.print(ch[i]);
              }
          }
      }

      //逐字节读取
        System.out.println();
      File f2 = new File(tmp, "byte_test.txt");
      try(OutputStream out = new FileOutputStream(f2)) {
          out.write("Hello 你好 世界".getBytes());
      }
        System.out.println("字节流写完，大小 = " + f2.length() + " 字节");

      try(InputStream in = new FileInputStream(f2)) {
          int b;
          int count = 0;
          while((b = in.read()) != -1) {
              count++;
              System.out.print(b + " ");
          }
          System.out.println();
          System.out.println("共读到  " + count + " 个字节");
      }

      //批量读取
        System.out.println();
      try (InputStream in = new FileInputStream(f2)) {
          byte[] buf = new byte[5];
          int n, round = 0;
          while((n = in.read(buf)) != -1) {
              round++;
              System.out.println("第" + round + "轮 读了 " + n + " 字节");
          }
      }

      //中文字节转字符会被截断
        System.out.println();
        try (InputStream in = new FileInputStream(f2)) {
            byte[] buf = new byte[5];
            int n, round = 0;
            while((n = in.read(buf)) != -1) {
                System.out.println("[" + new String(buf, 0, n) + "]");
            }
        }

        System.out.println();
        try(Reader r = new FileReader(f2)) {
            int c;
            int chars = 0;
            while((c= r.read()) != -1) chars++;
            System.out.println("字符流读到  " + chars + " 个字符");
        }
    }
}
