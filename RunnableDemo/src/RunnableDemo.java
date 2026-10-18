public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(), "R-线程");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.currentThread().setName("主线程");
        System.out.println("这是线程：" + Thread.currentThread().getName());

        MyRunnable2 m1 = new MyRunnable2();
        Thread t2 = new Thread(m1, "A");
        Thread t3 = new Thread(m1, "B");
        Thread t4 = new Thread(m1, "C");
        t2.start();
        t3.start();
        t4.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(m1.getCount());
    }
}

class MyRunnable implements Runnable {

//    public MyRunnable() {
//    }
//
//    public MyRunnable(String name)
//    }
    @Override
    public void run() {
        System.out.println("这是线程：" + Thread.currentThread().getName());
    }
}

class MyRunnable2 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
