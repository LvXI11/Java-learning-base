public class noDeadLockDemo {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK1) {
                    System.out.println("A 拿到 LOCK1");
                    sleep(200);
                    synchronized (LOCK2) {
                        System.out.println("A 拿到 LOCK2   → A 完成");
                    }
                }
            }
        }, "A").start();

        new Thread(new Runnable() {          // ★ B 也【先 LOCK1，再 LOCK2】
            @Override
            public void run() {
                synchronized (LOCK1) {
                    System.out.println("B 拿到 LOCK1");
                    sleep(200);
                    synchronized (LOCK2) {
                        System.out.println("B 拿到 LOCK2   → B 完成");
                    }
                }
            }
        }, "B").start();
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }
}