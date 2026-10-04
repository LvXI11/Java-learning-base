import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager test =new StudentManager();
        while(true){
            System.out.println("-----------------");
            System.out.println("1. 添加学生");
            System.out.println("2. 按姓名查找");
            System.out.println("3. 按姓名删除");
            System.out.println("4. 显示全部");
            System.out.println("5. 统计（总分 / 平均分 / 最高分）");
            System.out.println("6. 按分数降序排序");
            System.out.println("0. 退出");
            System.out.print("请选择：");
            int choice = scanner.nextInt();
            String name;
            int age;
            double score;
            switch (choice){
                case 1:
                    if(test.isFull()){
                        System.out.println("成员已满，不可添加");
                        break;
                    }
                    System.out.println("请分别输入：姓名 年龄 成绩");
                    name = scanner.next();
                    age = scanner.nextInt();
                    score = scanner.nextDouble();
                    test.addStudent(test.buildStudent(name,age,score));
                    break;
                case 2:
                        System.out.print("请输入你要查找学生的姓名：");
                        name = scanner.next();
                        if(test.findByName(name) != null) System.out.println("找到了学生：" + name);
                        else System.out.println("未找到学生：" + name);
                        break;
                case 3:
                    System.out.print("请输入你要删除学生的姓名：");
                    name = scanner.next();
                    if(test.removeStudentByName(name)) System.out.println("删除成功");
                    else System.out.println("删除失败");
                    break;
                case 4:
                        test.printAll();
                        break;
                case 5:
                    System.out.println("总分：" + test.TotaleScore());
                    System.out.println("平均分：" + test.AverageScore());
                    test.topStudet();
                    break;
                case 6: test.sortByScoreDesc();
                        test.printAll();
                        break;
                case 0:
                    System.out.println("已退出");
                    return;
                default:
                    System.out.println("输入错误，请重写输入");
            }
        }
    }
}
