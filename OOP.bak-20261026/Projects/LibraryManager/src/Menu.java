import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryItem[] library = new LibraryItem[10];
        LibraryManager using = new LibraryManager();

        System.out.println("-----------------");
        System.out.println("欢迎来的yy图使馆");
        System.out.println("-----------------");
        System.out.println();
        while(true){
            System.out.println("-----------------");
            System.out.println("1.添加馆藏");
            System.out.println("2.借书");
            System.out.println("3.还书");
            System.out.println("4.查书");
            System.out.println("5.显示所有书籍");
            System.out.println("6.统计书籍");
            System.out.println("0.退出");
            System.out.println("-----------------");
            System.out.print("请选择功能：");


            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("请输入编号：");
                    String id1 = scanner.next();
                    System.out.print("请输入书名；");
                    String name = scanner.next();
                    boolean selected1 = false;

                    while(true){
                        System.out.println("--------");
                        System.out.println("0.纸质书");
                        System.out.println("1.电子书");
                        System.out.println("--------");
                        System.out.print("请选择书籍类型：");
                        int type = scanner.nextInt();
                        switch (type){
                            case 0:
                                System.out.print("请输入页数：");
                                int pages = scanner.nextInt();
                                LibraryItem book1 = new PaperBook(id1, name, pages);
                                if(using.addBook(library,book1)){
                                    System.out.println("《" + name + "》" + "添加成功！");
                                }else{
                                    System.out.println("添加失败！");
                                }
                                selected1 = true;
                                break;
                            case 1:
                                System.out.print("请输入大小：");
                                double sizeGB = scanner.nextDouble();
                                LibraryItem book2 = new EBook(id1, name, sizeGB);
                                if(using.addBook(library,book2)){
                                    System.out.println("《" + name + "》" + "添加成功！");
                                }else{
                                    System.out.println("添加失败！");
                                }
                                selected1 = true;
                                break;
                            default:
                                System.out.print("输入错误，请重新输入：");
                        }
                        if(selected1) break;
                    }
                    break;
                case 2:
                    System.out.print("请输入需要借阅的书籍编号：");
                    String id2 = scanner.next();
                    if(using.borrowBook(library,id2)){
                        System.out.println("借阅成功！");
                    }else{
                        System.out.println("借阅失败！");
                    }
                    break;
                case 3:
                    System.out.print("请输入需要归还的书籍编号：");
                    String id3 = scanner.next();
                    if(using.givebackBook(library,id3)){
                        System.out.println("归还成功！");
                    }else{
                        System.out.println("归还失败！");
                    }
                    break;
                case 4:
                    boolean selected2 = false;
                    while(true){
                        System.out.println("---------------");
                        System.out.println("0.编号精确查找");
                        System.out.println("1.书名模糊查找");
                        System.out.println("---------------");
                        System.out.print("请选择查找模式：");
                        int pattern = scanner.nextInt();

                        switch (pattern){
                            case 0:
                                System.out.print("请输入编号：");
                                String id4 = scanner.next();
                                if(using.findBookById(library,id4)){
                                    System.out.println(" 找到此书");
                                }else{
                                    System.out.println("未找到此书");
                                }
                                selected2 = true;
                                break;
                            case 1:
                                System.out.print("请输入书名：");
                                String name2 = scanner.next();
                                if(using.findBookByName(library,name2)){
                                    System.out.println("找到相关书籍");
                                }else{
                                    System.out.println("未找到相关书籍");
                                }
                                selected2 = true;
                                break;
                            default:
                                System.out.print("输入错误，请重新输入：");
                        }
                        if(selected2) break;
                    }
                    break;
                case 5:
                    System.out.println("*********************");
                    using.showAllBooks(library);
                    System.out.println("*********************");
                    System.out.println("显示完毕！");
                    break;
                case 6:
                    using.countBooks(library);
                    break;
                case 0:
                    System.out.println("已退出！");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
