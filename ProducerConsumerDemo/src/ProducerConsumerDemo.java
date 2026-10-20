public class ProducerConsumerDemo {
    public static void main(String[] args) {
    int total = 20;
    Warehouse w = new Warehouse(5, total);

    Thread[] producers = new Thread[2];
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(w, total / 2), "生产者" + (i + 1));
            producers[i].start();
        }

        Thread[] consumers = new Thread[3];
        for(int i = 0;i < consumers.length; i++) {
            consumers[i] = new Thread(new Consumer(w), "消费者" + (i + 1));
            consumers[i].start();
        }

        for(Thread t : producers) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for(Thread t : consumers) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("主线程结束！");
    }
}

class Warehouse {
    private  final int[] items;
    private  final int capacity;
    private final int total;
    private int count;
    private int nextId = 1;
    private int taken;

    public Warehouse(int capacity, int total) {
        this.capacity = capacity;
        this.total = total;
        this.items = new int[capacity];
    }

    public synchronized void put() throws InterruptedException {
        while(count == capacity) {
            wait();
        }

        items[count++] = nextId++;
        System.out.println(Thread.currentThread().getName() + "生产" + items[count - 1]  + "，库存=" + count);
        notifyAll();
    }
    public synchronized int take() throws InterruptedException {
        while(count == 0) {
            if(taken >= total) {
                return -1;
            }
            wait();
        }
        int id = items[0];
        for(int i = 1;i < count; i++) {
            items[i - 1] = items[i];
        }
        count--;
        taken++;
        System.out.println(Thread.currentThread().getName() + "消费" + id + "，库存=" + count);
        notifyAll();
        return id;
    }
}

class Producer implements Runnable {
    private final Warehouse w;
    private final int times;

    Producer(Warehouse w, int times) {
        this.w = w;
        this.times = times;
    }

    @Override
    public void run() {
        for(int i = 0;i < times; i++) {
            try {
                w.put();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class Consumer implements Runnable {
    private final Warehouse w;

    public Consumer(Warehouse w) {
        this.w = w;
    }

    @Override
    public void run() {
        try {while(true) {
            int id = w.take();
            if(id < 0) {
                break;
            }
        }
        Thread.sleep(30);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}