package concurrency;

import java.util.concurrent.Phaser;

public class PhaserExample2 {

    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        new MyThread(myPhaser, "A");
        new MyThread(myPhaser, "B");
        new MyThread(myPhaser, "C");

        while (!myPhaser.isTerminated()){
            myPhaser.arriveAndAwaitAdvance();
        }

        System.out.println("Фазер завершен.");
    }

    static class MyPhaser extends Phaser{
        int numPhases;

        MyPhaser(int parties, int phaseCount) {
            super(parties);
            numPhases = phaseCount - 1;
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            System.out.println("Фaзa " + phase + " завершена.\n") ;
            return phase == numPhases || registeredParties == 0;
        }
    }

    static class MyThread implements Runnable{
        Phaser phaser;
        String name;

        MyThread(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (!phaser.isTerminated()){
                System.out.println("Поток " + name + " начинает " + phaser.getPhase() + "-ую фазу.");
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
