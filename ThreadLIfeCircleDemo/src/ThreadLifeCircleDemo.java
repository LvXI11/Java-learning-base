public class ThreadLifeCircleDemo {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        p("刚new出来：", t);

        t.start();
        p("start()后：", t);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        p("main线程 sleep(100)后：", t); sleep(100)后：     state= TERMINATED     isAlive=false
            p("t线程sleep(100)后：", t);

        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        p("join()后：", t);
    }

    static void p(String tag, Thread t) {
        System.out.printf("%-16s state= %-14s isAlive=%b%n", tag, t.getState(), t.isAlive());
    }
}
