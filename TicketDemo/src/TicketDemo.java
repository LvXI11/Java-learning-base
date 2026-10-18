public class TicketDemo {
    public static void main(String[] args) {
        Window w1 = new Window("A");
        Window w2 = new Window("B");
        Window w3 = new Window("C");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread {
    private static int tickets = 100;

    public Window() {
    }

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Window.class) {
                if(tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " 票：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
            }
    }
}

//    synchronized (Window.class) {
//        while(true) {
//            if(tickets > 0) {
//                System.out.println(Thread.currentThread().getName() + " 票：" + tickets);
//                tickets--;
//            } else {
//                break;
//            }
//        }
//    }
//}
//这中情况下只能是一个窗口卖票