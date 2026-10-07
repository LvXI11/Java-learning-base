public class GirlFriend{
    private  GirlFriend() {

    }

    private static  GirlFriend instance = new GirlFriend();

    public static GirlFriend getInstance(){
        return instance;
    }
}