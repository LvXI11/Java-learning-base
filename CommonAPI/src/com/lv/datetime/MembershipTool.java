package com.lv.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class MembershipTool {
    public static void main(String[] args) {
        LocalDate joinDate   = LocalDate.of(2026, 10, 28);
        LocalDate birthDate  = LocalDate.of(2005, 3, 15);

        LocalDate expireDate = joinDate.plusDays(30L);

        long days = ChronoUnit.DAYS.between(joinDate, expireDate);

        String joinWeek = joinDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.CHINA);
        String expireWeek = expireDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.CHINA);

        System.out.println("入会日期：" + joinDate + "(" + joinWeek + ")");
        System.out.println("到期日期：" + expireDate + "(" + expireWeek + ")");
        System.out.println("剩余天数：" + days);


        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String formatted = expireDate.atStartOfDay().format(fmt);

        Period age = Period.between(birthDate, joinDate);

        System.out.println("格式化    : " + formatted);
        System.out.println("年龄      : " + age.getYears() + "岁" +
                age.getMonths() + "个月" + age.getDays() + "天");
    }
}
