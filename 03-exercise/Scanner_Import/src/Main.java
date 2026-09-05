import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String str=sc.next(); // 读取字符串(空格前)
        String st=sc.nextLine();/*读到'\n'会直接返回空字符，
        缓存里面有'\n'需要nextLine()为后序的nextLien()消耗掉'\n'*/
        String line=sc.nextLine();// 读取整行(含空格)
        int num=sc.nextInt();
        double d=sc.nextDouble();
        sc.close();
        System.out.println("num="+num+"\nline="+line+"\nd="+d+"\nstr="+str);
    }
}
