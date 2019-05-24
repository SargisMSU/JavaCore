package concurrency;

import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;
        System.out.println("Start!!");
        new MyThread(phaser, "A");
        new MyThread(phaser, "B");
        new MyThread(phaser, "C");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена.");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена.");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена.");

        phaser.arriveAndDeregister();
        if (phaser.isTerminated()){
            System.out.println("Синхронизатор фаз завершен.");
        }
    }

    static class MyThread implements Runnable{
        Phaser phaser;
        String name;

        public MyThread(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Поток " + name + " начинает " + i + "-ую фазу");
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Поток " + name + "начинает " + "последную фазу");
            phaser.arriveAndDeregister();
        }
    }
}
