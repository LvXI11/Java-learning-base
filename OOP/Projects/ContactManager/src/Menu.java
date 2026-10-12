import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact[] contacts = new Contact[500];
        ContactsManager using = new ContactsManager();
        System.out.println("----------------");
        System.out.println("    电话簿");
        System.out.println("----------------");
        System.out.println();
        boolean selectFunctionSucceed = false;
        while(true){
            System.out.println("----------------------");
            System.out.println("1.添加联系人");
            System.out.println("2.删除联系人");
            System.out.println("3.修改联系人");
            System.out.println("4.查询联系人");
            System.out.println("5.显示所有联系人");
            System.out.println("0.退出程序");
            System.out.println("----------------------");
            System.out.print("请选择功能：");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("请输入姓名：");
                    String name1 = scanner.next();
                    System.out.println();
                    Contact contact = new Contact(name1, null);
                    while (true){
                        boolean inputCorrect = false;
                        System.out.print("请输入电话号码：");
                        if(contact.setPhoneNumber(scanner.next())){
                            inputCorrect = true;
                        }else{
                            System.out.println("电话号码格式不对");
                        }
                        if(inputCorrect) break;
                    }
                    System.out.println("(可选)添加邮箱(是/否):");
                    String selection = null;
                    while(true){
                        selection = scanner.next();
                        if(selection.equals("是") || selection.equals("否")){
                            break;
                        }else{
                            System.out.println("输入错误，请重新输入");
                        }
                    }
                    if(selection.equals("是")){
                        System.out.print("请输入邮箱：");
                        contact.setEmail(scanner.next());
                    }
                    if(using.addContact(contacts,contact)){
                        System.out.println("添加成功！");
                    }else{
                        System.out.println("添加失败！");
                    }
                    selectFunctionSucceed = true;
                    break;
                case 2:
                    System.out.print("请输入要删除联系人的姓名：");
                    if(using.removeContact(contacts, scanner.next())){
                        System.out.println("删除成功！");
                    }else{
                        System.out.println("删除失败！");
                    }
                    selectFunctionSucceed = true;
                    break;
                case 3:
                    System.out.print("请输入你要修改的联系人姓名：");
                    int index = using.modifyContact(contacts, scanner.next());
                    if(index != -1){
                        boolean selectContentSucceed = false;
                        while(true){
                            System.out.println("-----------------");
                            System.out.println("1.姓名");
                            System.out.println("2.电话号码");
                            System.out.println("3.邮箱");
                            System.out.println("-----------------");
                            System.out.print("请选择你要修改的内容：");
                            int selectContent = scanner.nextInt();
                            switch (selectContent){
                                case 1:
                                    System.out.print("请输入姓名：");
                                    contacts[index].setName(scanner.next());
                                    selectContentSucceed = true;
                                    break;
                                case 2:
                                    System.out.print("请输入电话号码：");
                                    if(contacts[index].setPhoneNumber(scanner.next())){
                                        selectContentSucceed = true;
                                    }else{
                                        System.out.println("电话号码没改成功，请重新输入");
                                    }
                                    break;
                                case 3:
                                    System.out.print("请输入邮箱：");
                                    contacts[index].setEmail(scanner.next());
                                    selectContentSucceed = true;
                                    break;
                                default:
                                    System.out.println("输入错误，请重新输入");
                            }
                            if(selectContentSucceed) break;
                        }
                        System.out.println("修改成功！");
                    }else{
                        System.out.println("修改失败！");
                    }
                    selectFunctionSucceed = true;
                    break;
                case 4:
                    while(true){
                        System.out.println("-----------");
                        System.out.println("0.按姓名查找");
                        System.out.println("1.关键字查找");
                        System.out.println("-----------");
                        System.out.print("请选择：");
                        int pattern = scanner.nextInt();
                        boolean selectPatternSucceed = false;
                        switch (pattern){
                            case 0:
                                System.out.print("请输入姓名：");
                                if(using.searchContactByName(contacts, scanner.next())){
                                    System.out.println("找到此联系人");
                                }else{
                                    System.out.println("未找到此联系人");
                                }
                                selectPatternSucceed = true;
                                break;
                            case 1:
                                System.out.print("请输入姓名：");
                                if(using.searchContactByKeyword(contacts, scanner.next())){
                                    System.out.println("找到此联系人");
                                }else{
                                    System.out.println("未找到此联系人");
                                }
                                selectPatternSucceed = true;
                                break;
                            default:
                                System.out.println("输入错误，请重新输入");
                        }
                        if(selectPatternSucceed) break;
                    }
                    selectFunctionSucceed = true;
                    break;
                case 5:
                    using.displayAllContacts(contacts);
                    selectFunctionSucceed = true;
                    break;
                case 0:
                    System.out.println("已退出");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
