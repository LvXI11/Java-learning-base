public class ThreadMethodDemo {
    public static void main(String[] args) {

        //        interrupt()
        Thread t5 = new Thread("线程5"){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("被中断了!");
                }
            }
        };
        t5.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t5.interrupt();

//        名字和当前线程
        Thread t = new Thread("工作线程"){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        };
        System.out.println(t.getName());
        t.setName("改名后");
        System.out.println(t.getName());
        t.setName("线程1");
        System.out.println(Thread.currentThread().getName());

//        优先级
        Thread t2 = new Thread("线程2"){
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                        静态方法sleep()
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        t.setPriority(10);
//        t.setPriority(11);IllegalArgumentException
        t2.setPriority(1);
        t.start();
        t2.start();

//        isAlive()
        Thread t3 = new Thread("线程3"){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        System.out.println(t3.isAlive());
        t3.start();
        System.out.println(t3.isAlive());
//        join()
        Thread t4 = new Thread("线程4"){
            @Override
            public void run() {
                System.out.println("这是" + Thread.currentThread().getName());
            }
        };
        t4.start();
        try {
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
