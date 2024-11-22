package kafkaTestContainer.playground;

import java.util.concurrent.locks.ReentrantLock;

public class CollectionsPG {
    public static void main(String... args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");
        foo.second(r2);
        foo.first(r1);
        foo.third(r3);
    }
}

class Foo {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
//try(lock1.tryLock())
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
