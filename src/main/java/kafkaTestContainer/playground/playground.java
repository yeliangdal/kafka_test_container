package kafkaTestContainer.playground;


import kotlin.jvm.Synchronized;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Playground {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private int c = 0;

    public void incrementAtomicInteger() {
        counter.getAndAdd(1);
    }

    public void incrementCounter(Lock lock) {
        try {
            lock.lock();
            c++;
            System.out.print(this.getC()+" ");
        } finally {
            lock.unlock();
        }
    }

    public void incrementCounter() {
        c++;
        System.out.print(this.getC()+" ");
    }

    public int getC() {
        return c;
    }

    public void printAA() {
        System.out.println("AA");
    }

    public void printBB() {
        System.out.println("BB");
    }
    public void printCC() {
        System.out.println("CC");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) throws BrokenBarrierException, InterruptedException {
        printAA();
        c1.await();
        printBB();
        c2.await();
        printCC();
    }

    public void test() throws InterruptedException {

        Runnable r1 = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.print("AA");
            }
        };

        Runnable r2 = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.print("BB");
            }
        };

    }

    static class PrintNums implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        System.out.println(List.of(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0, (a,b) -> (a - b)));

    }
}

class KeyClass {
    private String name;
    private Integer num;
    public KeyClass(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KeyClass keyClass = (KeyClass) o;
        return Objects.equals(name, keyClass.name) && Objects.equals(num, keyClass.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }
}
