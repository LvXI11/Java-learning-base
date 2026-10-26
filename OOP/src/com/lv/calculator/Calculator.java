package com.lv.calculator;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Calculator {

    public static float readNumber(Scanner scanner, String promt) {
        while (true) {
            System.out.print(promt);
            String input = scanner.next();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请重新输出");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selection = null;

        float firstOperand = readNumber(scanner,"请输入第一个数：");
        float secondOperand = readNumber(scanner, "请输入第二个数：");

            String operator = null;

            while(true){
                System.out.print("请输入运算符（+、-、*、/）：");
                operator = scanner.next();
                if(operator.equals("+") || operator.equals("-") ||
                        operator.equals("*") || operator.equals("/")){
                    break;
                }else{
                    System.out.println("输入错误，请重新输入");
                }
            }

            float result = 0;
            if(operator.equals("+")) result = firstOperand + secondOperand;
            if(operator.equals("-")) result = firstOperand - secondOperand;
            if(operator.equals("*")) result = firstOperand * secondOperand;
            boolean countError = false;
            if(operator.equals("/")){
                if(secondOperand == 0){
                    System.out.println(firstOperand + "不能被" + secondOperand + "整除");
                    countError = true;
                }else{
                    result = firstOperand / secondOperand;
                }
            }

            if(countError){
                System.out.println("无法计算");
            }else{
                System.out.println("结果是：" + firstOperand +
                        operator + secondOperand + "=" + result);
            }

            System.out.println("请问要退出吗？y/n");
            while (true){
                selection = scanner.next();
                if(selection.equals("y") || selection.equals("n")){
                    break;
                }else{
                    System.out.println("输入错误，请重新输入");
                }
            }

            if(selection.equals("y")){
                System.out.println("程序结束！");
                return;
            }
        }
}
