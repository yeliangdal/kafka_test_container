package kafkaTestContainer.playground;

import java.util.concurrent.Semaphore;

class FooBar2 {
    private int n;
    Semaphore foo, bar;

    public FooBar2(int n) {
        this.n = n;
        foo = new Semaphore(1);
        bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public static void main(String... args) throws InterruptedException {
        FooBar2 fooBar = new FooBar2(5);
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