package kafkaTestContainer.playground;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    Semaphore printZero, printOdd, printEven;

    public ZeroEvenOdd(int n) {
        this.n = n;
        printZero = new Semaphore(1);
        printOdd = new Semaphore(0);
        printEven = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i<=n; i++) {
            printZero.acquire();
            printNumber.accept(0);
            if (i%2==0) {
                printEven.release();
            }
            else {
                printOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i<=n; i+=2) {
            printEven.acquire();
            printNumber.accept(i);
            printZero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i<=n; i+=2) {
            printOdd.acquire();
            printNumber.accept(i);
            printZero.release();
        }
    }


    public static void main(String... args) throws InterruptedException {
        ZeroEvenOdd z = new ZeroEvenOdd(5);
        IntConsumer printNum = System.out::print;
        new Thread(()-> {
            try {
                z.zero(printNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                z.odd(printNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                z.even(printNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
