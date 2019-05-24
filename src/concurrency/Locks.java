package concurrency;

import java.util.concurrent.CountDownLatch;

public class Locks {

    private static class Generator {
        private final CountDownLatch latch;

        private Generator(CountDownLatch latch) {
            this.latch = latch;
        }

        void generate() {
            try {
                Thread.sleep(750);
                System.out.println("generated");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void stop() throws InterruptedException {
            latch.await();
            System.out.println("Stopped");
        }
    }

    public static void main(String[] args) throws Exception {
        latchDemo();
    }

    private static void latchDemo() {
        int counts = 5;
        CountDownLatch latch = new CountDownLatch(counts);

        Generator generator = new Generator(latch);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < counts; i++) {
                generator.generate();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                generator.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();
    }
}