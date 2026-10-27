package com.lv.stringapi;

public class ConcatBench {
    static String concatString(int n) {
        String str = new String();
        double start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            str += "i";
        }
        double end = System.nanoTime();
        System.out.println("String 花费时间=" +
                String.format("%.1f", Double.valueOf(((double)end - start)) / 1e6) +
                " len=" + str.length());
        return str;
    }

    static StringBuilder concatBuilder(int n) {
        StringBuilder str = new StringBuilder();
        double start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            str.append("i");
        }
        double end = System.nanoTime();
        System.out.println("StringBuilder 花费时间=" +
                String.format("%.1f", Double.valueOf(((double)end - start)) / 1e6) +
                " len=" + str.length());
        return str;
    }

    static StringBuffer concatBuffer(int n) {
        StringBuffer str = new StringBuffer();
        double start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            str.append("i");
        }
        double end = System.nanoTime();
        System.out.println("StringBuffer 花费时间=" +
                String.format("%.1f", Double.valueOf((end - start)) / 1e6) +
                " len=" + str.length());
        return str;
    }

    public static void main(String[] args) {

        String  s1;
        StringBuilder s2;
        StringBuffer s3;
        s1 = concatString(10000);
        s2 = concatBuilder(10000);
        s3 = concatBuffer(10000);

    }
}
