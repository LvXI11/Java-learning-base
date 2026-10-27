package com.lv.stringapi;

public class CsvReport {
    public static void main(String[] args) {
        String[] rows = {
                " 101 , zhangSan ,  90 ",
                "102,lisi,85",
                "103 , wangwu , 78 "
        };

        int sum = 0;

        for(String raw : rows) {
            String[] parts = raw.split(",");

            String id = parts[0].trim();
            String name = parts[1].trim();
            String scoreStr = parts[2].trim();

            int score = Integer.parseInt(scoreStr);
            sum += score;

            String name2 = name.substring(0,1).toUpperCase() +
                    name.substring(1,name.length()).toLowerCase();

            String grade ;
            if(score >= 90) {
                grade = "A";
            }else if(score >= 80) {
                grade = "B";
            }else if(score >= 60) {
                grade = "C";
            }else {
                grade = "D";
            }

            System.out.println("学号=" + id + " 姓名=" + name2 +
                    " 成绩=" + score + " 等级=" + grade);
        }

        System.out.println("共" + rows.length + "条" +
                " 平均分 " + String.format("%.1f", Double.valueOf((double)sum / rows.length) ));
        System.out.println("原始数据未被改动：[" + rows[0] + "]");
    }
}
