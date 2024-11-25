package kafkaTestContainer.playground;

import java.util.concurrent.Semaphore;


public class CollectionsPG {
    public static void main(String... args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");
        new Thread(()-> {
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


}

class Foo {
    Semaphore isSecondReady = new Semaphore(0);
    Semaphore isThirdReady = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            printFirst.run();
        } finally {
            isSecondReady.release(1);
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            isSecondReady.acquire();
            printSecond.run();
        } finally {
            isThirdReady.release(1);
        }
//        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            isThirdReady.acquire();
            printThird.run();
        } finally {
            isThirdReady.release();
        }
    }
}
