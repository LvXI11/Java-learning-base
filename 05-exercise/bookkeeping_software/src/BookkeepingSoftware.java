import java.util.ArrayList;
import java.util.Scanner;

public class BookkeepingSoftware {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Record> records = new ArrayList<>();
        boolean con=true;
        while (con){
            System.out.println("\n=== 个人记账本 ===");
            System.out.print("     1. 记账\n");
            System.out.print("     2. 查看账单\n");
            System.out.print("     3. 统计汇总\n");
            System.out.print("     4. 退出\n");
            System.out.print("     请选择(1-4):");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("金额：");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("类型(收入/支出)：");
                    String type=  sc.nextLine();
                    System.out.print("类别(餐饮/交通/工资等)");
                    String category =sc.nextLine();
                    System.out.print("备注：");
                    String note = sc.nextLine();
                    System.out.print("日期(如2026-09-08，直接回车用今天): ");
                    String date = sc.nextLine();
                    if(date.isEmpty()) date = java.time.LocalDate.now().toString();
                    Record r = new Record(amount, type, category, note, date);
                    records.add(r);
                    System.out.println("记账成功");
                    break;
                case 2:
                    if(records.isEmpty()) System.out.println("暂无账单");
                    else {
                        System.out.println("---所有账单---");
                        for(int i=0;i<records.size();i++){
                            Record re =records.get(i);
                            System.out.printf("%d. %s %.2f [%s] %s %s%n",
                                    i+1, re.type,re.amount,re.category,re.date,re.note);
                        }
                    }
                    break;
                case 3:
                    double income = 0, expense = 0;
                    for(Record rec : records){
                        if(rec.type.equals("收入")) income += rec.amount;
                        else if(rec.type.equals("支出")) expense += rec.amount;
                    }
                    System.out.printf("\n总收入：%.2f 总支出：%.2f 结余：%.2f",
                            income,expense,income-expense);
                    break;
                case 4:
                    con=false;
                    System.out.println("已退出\n");break;
                default:
                    System.out.println("输入错误，请重写输入：");
            }
        }
    }
}