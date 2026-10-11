public class ContactsManager {
    private static int count = 0;

    public boolean addContact(Contact[] contacts, Contact contact){
        if(count == contacts.length){
            System.out.println("成员已满，不可添加");
            return false;
        }
        for (int i = 0; i < count; i++) {
            if(contacts[i].getName().equals(contact.getName())){
                System.out.println("电话簿中已有此联系人");
                return false;
            }
            if(contacts[i].getPhoneNumber().equals(contact.getPhoneNumber())){
                System.out.println("电话簿中已有此号码");
                return false;
            }
        }
        contacts[count ++] = contact;
        return true;
    }

    public boolean removeContact(Contact[] contacts, String name){
        if(count == 0){
            System.out.println("电话簿为空");
            return false;
        }

        int index = -1;
        for (int i = 0; i < count; i++) {
            if(contacts[i].getName().equals(name)){
                index = i;
            }
        }
        if(index != -1){
            for(int i = index;i < count - 1; i++){
                contacts[i] = contacts[i + 1];
            }
            count--;
            return true;
        }else{
            System.out.println("未找到此联系人");
            return false;
        }
    }

    public int modifyContact(Contact[] contacts, String name){
        if(count == 0){
            System.out.println("电话簿为空");
            return -1;
        }
        for(int i = 0;i < count; i++){
            if(contacts[i].getName().equals(name)){
                return i;
            }
        }
        System.out.println("未找到此联系人");
        return -1;
    }

    public boolean searchContactByName(Contact[] contacts, String name){
        if(count == 0){
            System.out.println("电话簿为空");
            return false;
        }
        for(int i = 0;i < count; i++){
            if(contacts[i].getName().equals(name)){
                System.out.println(contacts[i].getInfo());
                return true;
            }
        }
        return false;
    }

    public boolean searchContactByKeyword(Contact[] contacts, String keyword){
        if(count == 0){
            System.out.println("电话簿为空");
            return false;
        }
        boolean found = false;
        for(int i = 0;i < count; i++){
            boolean matched = false;
            if(contacts[i].getName().contains(keyword)){
                matched = true;
            }
            if(contacts[i].getPhoneNumber().contains(keyword)){
                matched = true;
            }
            if(matched){
                System.out.println(contacts[i].getInfo());
                found = true;
            }
        }
        return found;
    }

    public void displayAllContacts(Contact[] contacts){
        if(count == 0){
            System.out.println("电话簿为空");
            return;
        }
        System.out.println("*******************************************");
        for (int i = 0; i < count; i++) {
            System.out.println(contacts[i].getInfo());
        }
        System.out.println("*******************************************");
        System.out.println("显示完毕");
    }
}
