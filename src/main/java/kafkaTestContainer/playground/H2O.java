package kafkaTestContainer.playground;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class H2O {
    CyclicBarrier cyclicBarrier;
    Semaphore hydrogen, oxygen;
    public H2O() {
        cyclicBarrier = new CyclicBarrier(3);
        hydrogen = new Semaphore(2);
        oxygen = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try{
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        hydrogen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try{
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        oxygen.release();
    }

    public static void main(String... args) throws InterruptedException {
        H2O h2o = new H2O();
        Runnable r1 = () -> System.out.println("h");
        Runnable r2 = () -> System.out.println("o");
        int count = 5;

        IntStream.range(0, 2*count)
                .parallel()
                .forEach(i -> {
                    new Thread(() -> {
                        try {
                            h2o.hydrogen(r1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                });
        IntStream.iterate(0, i->i<count, i->i+1)
                .forEach(i -> {
                    new Thread(() -> {
                        try {
                            h2o.oxygen(r2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                        }
                );
    }
}