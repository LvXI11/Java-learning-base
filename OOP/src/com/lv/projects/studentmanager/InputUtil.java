package com.lv.projects.studentmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    static int readInt(Scanner scanner, String prompt){
        while(true){
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("输入错误，请重新输入");
                scanner.nextLine();
            }
        }
    }

    static double readDouble(Scanner scanner, String prompt){
        while(true){
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            }catch (InputMismatchException e) {
                System.out.println("输入错误，请重新输入");
                scanner.nextLine();
            }
        }
    }
}
