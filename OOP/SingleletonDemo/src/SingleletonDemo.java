public class SingleletonDemo {

    public static void main(String[] args) {
    GirlFriend girlFriend1 = GirlFriend.getInstance();
    GirlFriend girlFriend2 = GirlFriend.getInstance();
        System.out.println(girlFriend1 == girlFriend2);
    }
}

