package kafkaTestContainer.playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {
    int capacity;
    Queue<Integer> queue;
    ReentrantLock lock;
    Condition isFull, isEmpty;
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
        lock = new ReentrantLock();
        isFull = lock.newCondition();
        isEmpty = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        try{
            lock.lock();
            if (queue.size()==capacity){
                isFull.await();
            }
            queue.add(element);
            isEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        try{
            lock.lock();
            if(queue.size()==0) {
                isEmpty.await();
            }
            var ret = queue.remove();
            isFull.signalAll();
            return ret;
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        try{
            lock.lock();
            return queue.size();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String... args) throws InterruptedException {
        BoundedBlockingQueue q = new BoundedBlockingQueue(2);
        new Thread(() -> {
            try {
                q.enqueue(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                q.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                q.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                q.enqueue(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                q.enqueue(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                q.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}