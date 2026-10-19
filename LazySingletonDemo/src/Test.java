public class Test {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(m1);
            t.start();
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
class MyThread implements Runnable {
    @Override
    public void run() {

        LazySingleton l1 = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + l1.hashCode());
    }
}