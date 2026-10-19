public class LazySingleton {
    private static final Object LOCK = new Object();

    private LazySingleton() {
        System.out.println("实例被创建");
    }

    private static LazySingleton singleton = null;


    public static LazySingleton getInstance() {
        if(singleton == null) {
            synchronized (LOCK) {
                if(singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
