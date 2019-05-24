package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("Барьер достигнут!"));
        for (int i = 0; i < 10; i++) {
            new MyThread("MyThread N" + i, cyclicBarrier);
        }
    }

    static class MyThread extends Thread{
        CyclicBarrier cyclicBarrier;
        String name;

        public MyThread(String name, CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
            start();
        }

        @Override
        public void run() {
            System.out.println("Thread: " + name);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
