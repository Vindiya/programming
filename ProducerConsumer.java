// producer consumer architecture
// first the producer produces articles and puts into the storage
// then the consumer checks the storage for an item they require, if its available they get it else they're blocked from it
// producer checks if the storage is full, if so they wait for vacant space to put their product
// size? or uniform size of all products?
// R:W ratio which in this case would be consumer querying the data to get what they want and write is producer
// putting data in there
// max cap on storage?
// [ | | | | ]
// consumer and a producer thread
// queue itself can notify them if its empty or if its full
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class ProducerConsumer {
    public static void main(String[] args) {
        // thread safe
        // can be accessed by multiple threads
        BlockingQueue<Item> bq = new ArrayBlockingQueue<Item>(10);

        Runnable producer = () -> {
            while(true) {
                bq.add(createItem());
            }
        };
        Runnable consumer = () -> {
            while(true) {
                Item i = bq.poll();
            }
        };
        Thread producer1 = new Thread(producer);
        Thread producer2 = new Thread(producer);
        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
class MyBlockingQueue {
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();
    Queue<E> q;
    int capacity;
    Reentrantlock lock = new Reentrantlock(true);
    public MyBlockingQueue(int size) {
        q = new LinkedList<>();
        this.capacity = size;
    }
    // implement without blocking queue
    // create blocking queue
    public void put(Item item) {
        lock.lock();
        try {
            while(q.size()==max) {
                notFull.await();
            }
            q.add(item);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public Item get() {
        lock.lock();
        try {
            while(q.size()==0) {
                notEmpty.await();
            }
            item = q.poll();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }
}
class MyBlockingQueue {
    Object notEmpty = Object();
    Object notFull = Object();
    Queue<E> q;
    int capacity;
    public MyBlockingQueue(int size) {
        q = new LinkedList<>();
        this.capacity = size;
    }
    // implement without blocking queue
    // create blocking queue
    public synchronized void put(Item item) {
        try {
            while(q.size()==max) {
                notFull.wait();
            }
            q.add(item);
            notEmpty.notifyAll();
        }
    }
    public synchronized Item get() {
        try {
            while(q.size()==0) {
                notEmpty.wait();
            }
            item = q.poll();
            notFull.notifyAll();
            return item;
        }
    }
}
