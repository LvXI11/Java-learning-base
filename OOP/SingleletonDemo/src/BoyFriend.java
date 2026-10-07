public class BoyFriend{
    private BoyFriend(){

    }

    private static  BoyFriend instance = null;

    public static BoyFriend getInstance(){
        if(instance == null){
            instance = new BoyFriend();
        }
        return instance;
    }
}