package kafkaTestContainer.playground;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    private Semaphore fizzSemaphore, buzzSemaphore, fizzbuzzSemaphore, numberSemaphore;
    public FizzBuzz(int n) {
        this.n = n;
        fizzSemaphore = new Semaphore(0);
        buzzSemaphore = new Semaphore(0);
        fizzbuzzSemaphore = new Semaphore(0);
        numberSemaphore = new Semaphore(1);
    }



    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i=3; i<=n; i+=3) {
            if(i%5 != 0) {
                fizzSemaphore.acquire();
                printFizz.run();
                numberSemaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i=5; i<=n; i+=5) {
            if(i%3 != 0) {
                buzzSemaphore.acquire();
                printBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i=15; i<=n; i+=15) {
            fizzbuzzSemaphore.acquire();
            printFizzBuzz.run();
            numberSemaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<= n; i++) {
            numberSemaphore.acquire();
            if (i%3==0 && i%5 == 0){
                fizzbuzzSemaphore.release(1);
            } else if(i%3==0) {
                fizzSemaphore.release(1);
            } else if(i%5==0) {
                buzzSemaphore.release(1);
            } else {
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
    }

    public static void main(String... args) {
        FizzBuzz f = new FizzBuzz(15);
        new Thread(()-> {
            try {
                f.fizz(()->System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                f.buzz(()->System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                f.fizzbuzz(()->System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                f.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
