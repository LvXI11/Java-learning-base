public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null) return false;
        if(phoneNumber.length() > 11){
            System.out.println("号码的位数不对(应小于等于11位)");
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if(!Character.isDigit(phoneNumber.charAt(i))){
                System.out.println("号码只能为数字！");
                return false;
            }
        }
        this.phoneNumber = phoneNumber;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo(){
        return "姓名：" + name + " 电话号码：" +
                phoneNumber + " 邮箱：" +
                (email == null ? "无" : email );
    }
}
