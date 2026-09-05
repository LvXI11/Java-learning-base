import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Random r=new Random(100);
        int target=r.nextInt(100)+1;
        int guess=0;
        while(guess!=target){
            System.out.print("请输入你猜的数(1~100)：");
            Scanner sc=new Scanner(System.in);
            guess=sc.nextInt();
            if(guess>target)System.out.println("大了");
            else System.out.println("小了");
        }
        System.out.println("恭喜你猜对了，为"+target);
    }
}
