public class DeadLockDemo {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        //线程 A:先 LOCK1, 再LOCK2
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK1) {
                    System.out.println("A 拿到 LOCK1");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (LOCK2) {
                        System.out.println("A拿到 LOCK2  -> A 完成");
                    }
                }
            }
        },"A").start();

        //线程 B：先LOCK2 ，再 LOCK1
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK2) {
                    System.out.println("B 拿到 LOCK2");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (LOCK1) {
                        System.out.println("B拿到 LOCK1  -> B 完成");
                    }
                }
            }
        },"B").start();
    }
}
