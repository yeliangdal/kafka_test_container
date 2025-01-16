package kafkaTestContainer.playground;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class DiningPhilosophers {
    ReentrantLock[] locks;
    public DiningPhilosophers() {
        locks = new ReentrantLock[5];
        IntStream.range(0,5)
                .forEach(i -> locks[i] = new ReentrantLock());
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = (philosopher+1)%5;
        int right = philosopher ;
        locks[left].lock();
        pickLeftFork.run();
        locks[right].lock();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        locks[left].unlock();
        putRightFork.run();
        locks[right].unlock();
    }

    public static void main(String... args) throws InterruptedException {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        new Thread(()-> {
            try {
                diningPhilosophers.wantsToEat(0,
                        () -> System.out.println("p0 picks up left fork"),
                        () -> System.out.println("p0 picks up right fork"),
                        () -> System.out.println("p0 starts to eat"),
                        () -> System.out.println("p0 put down left fork"),
                        () -> System.out.println("p0 put down right fork"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                diningPhilosophers.wantsToEat(1,
                        () -> System.out.println("p1 picks up left fork"),
                        () -> System.out.println("p1 picks up right fork"),
                        () -> System.out.println("p1 starts to eat"),
                        () -> System.out.println("p1 put down left fork"),
                        () -> System.out.println("p1 put down right fork"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                diningPhilosophers.wantsToEat(2,
                        () -> System.out.println("p2 picks up left fork"),
                        () -> System.out.println("p2 picks up right fork"),
                        () -> System.out.println("p2 starts to eat"),
                        () -> System.out.println("p2 put down left fork"),
                        () -> System.out.println("p2 put down right fork"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                diningPhilosophers.wantsToEat(3,
                        () -> System.out.println("p3 picks up left fork"),
                        () -> System.out.println("p3 picks up right fork"),
                        () -> System.out.println("p3 starts to eat"),
                        () -> System.out.println("p3 put down left fork"),
                        () -> System.out.println("p3 put down right fork"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                diningPhilosophers.wantsToEat(4,
                        () -> System.out.println("p4 picks up left fork"),
                        () -> System.out.println("p4 picks up right fork"),
                        () -> System.out.println("p4 starts to eat"),
                        () -> System.out.println("p4 put down left fork"),
                        () -> System.out.println("p4 put down right fork"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

