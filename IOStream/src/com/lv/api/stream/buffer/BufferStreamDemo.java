package com.lv.api.stream.buffer;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");

        File big = new File(tmp, "big.bin");
        try(OutputStream o = new BufferedOutputStream(new FileOutputStream(big))) {
            byte[] chunk = new byte[1024];
            for(int i = 0;i < 1024; i++) o.write(chunk);
        }
        System.out.println("big.bin = " + big.length() + " 字节");

        //无缓存
        long t1 = System.currentTimeMillis();
        try(InputStream in = new FileInputStream(big)) {
            try(OutputStream out = new FileOutputStream(new File(tmp, "copy1.bin"))) {
                int b;
                while((b = in.read()) != -1) out.write(b);
            }
        }
        long cost1 = System.currentTimeMillis() - t1;

        //缓存流
        long t2 = System.currentTimeMillis();
        try(InputStream in = new BufferedInputStream(new FileInputStream(big));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(tmp, "copy2.bin")))) {
            int b;
            while((b = in.read()) != -1) out.write(b);
        }
        long cost2 = System.currentTimeMillis() - t2;

        System.out.println("无缓冲 " + cost1 + " ms / 有缓冲 " + cost2 + " ms");

        File txt  = new File(tmp, "lines.txt");
        try(BufferedWriter w = new BufferedWriter(new FileWriter(txt))) {
            w.write("第一行");
            w.newLine();
            w.write("第二行 abc");
            w.newLine();
            w.write("第三行");
            w.newLine();
        }

        try(BufferedReader r = new BufferedReader(new FileReader(txt))) {
            String line;
            int no = 0;
            while ((line = r.readLine()) != null) {
                no++;
                System.out.println(no + ": [" + line + "] len=" + line.length());
            }
        }
    }
}
