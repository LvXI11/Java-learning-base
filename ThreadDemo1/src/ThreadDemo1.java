public class ThreadDemo1 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
//        myThread.start();Exception in thread "main" java.lang.IllegalThreadStateException
        MyThread myThread1 = new MyThread();
//        myThread1.run(); 是在main这个主线程运行MyThread的run方法
        new MyThread().start();
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
