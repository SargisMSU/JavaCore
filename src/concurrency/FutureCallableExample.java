package concurrency;

import java.util.concurrent.*;

public class FutureCallableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Integer> f;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Start!");

        f = executorService.submit(new Sum(1000000));
        f2 = executorService.submit(new Hypot(31000000, 41000000));
        f3 = executorService.submit(new Factorial(10));

        try {
            System.out.println("f.get() = " + f.get());
            System.out.println("f2.get() = " + f2.get());
            System.out.println("f3.get() = " + f3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("End");
    }

    static class Sum implements Callable<Integer>{
        int stop;

        Sum(int v){
            stop = v;
        }

        public Integer call(){
            int sum = 0;
            for (int i = 1; i <= stop; i++) {
                sum += i;
            }
            return sum;
        }
    }

    static class Hypot implements Callable<Double>{
        double side1, side2;

        public Hypot(double side1, double side2) {
            this.side1 = side1;
            this.side2 = side2;
        }

        @Override
        public Double call() {
            return Math.sqrt(side1*side1 + side2*side2);
        }
    }

    static class Factorial implements Callable<Integer>{
        int stop;

        public Factorial(int stop) {
            this.stop = stop;
        }

        @Override
        public Integer call() {
            int fact = 1;
            for (int i = 2; i < stop; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}
