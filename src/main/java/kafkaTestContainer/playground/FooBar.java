package kafkaTestContainer.playground;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;

    ReentrantLock lock = new ReentrantLock();
    Condition wait = lock.newCondition();
//    Condition barWait = lock.newCondition();

    AtomicBoolean isFooTurn = new AtomicBoolean(true);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (lock.tryLock()) {
                try{
                    while (!isFooTurn.get()){
                        wait.await();
                    }
                    printFoo.run();
                    isFooTurn.set(false);
                } finally {
                    wait.signalAll();
                    lock.unlock();
                }
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            if (lock.tryLock()) {
                try{
                    while (isFooTurn.get()){
                        wait.await();
                    }
                    printBar.run();
                    isFooTurn.set(true);
                } finally {
                    wait.signalAll();
                    lock.unlock();
                }
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }

    public static void main(String... args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);
        Runnable r1 = () -> System.out.println("foo");
        Runnable r2 = () -> System.out.println("bar");
        new Thread(()-> {
            try {
                fooBar.foo(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fooBar.bar(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}