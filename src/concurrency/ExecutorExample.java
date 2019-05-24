package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatch countDownLatch2 = new CountDownLatch(5);
        CountDownLatch countDownLatch3 = new CountDownLatch(5);
        CountDownLatch countDownLatch4 = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new MyThread(countDownLatch, "A"));
        executorService.execute(new MyThread(countDownLatch2, "B"));
        executorService.execute(new MyThread(countDownLatch3, "C"));
        executorService.execute(new MyThread(countDownLatch4, "D"));

        try {
            countDownLatch.await();
            countDownLatch2.await();
            countDownLatch3.await();
            countDownLatch4.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("---end---");
    }

    static class MyThread implements Runnable{
        String name;
        CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch, String name) {
            this.name = name;
            this.countDownLatch = countDownLatch;
            new Thread(this);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + ": " + i);
                countDownLatch.countDown();
            }
        }
    }
}
