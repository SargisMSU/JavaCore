package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }
        Count count = new Count(numbers, 0, numbers.length, t -> t > 0.5);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(count);
        System.out.println("count.join() = " + count.join());
    }

    interface Filter{
        boolean accept(double t);
    }

    static class Count extends RecursiveTask<Integer>{
        static final int limit = 1000;
        private double[] values;
        private int from;
        private int to;
        private Filter filter;

        public Count(double[] values, int from, int to, Filter filter) {
            this.values = values;
            this.from = from;
            this.to = to;
            this.filter = filter;
        }

        @Override
        protected Integer compute() {
            if (to - from < limit){
                int count = 0;
                for (int i = from; i < to; i++) {
                    if (filter.accept(values[i])) count++;
                }
                return count;
            }else {
                int mid = (to + from) / 2;
                Count first = new Count(values, from, mid, filter);
                Count second = new Count(values, mid, to, filter);
                invokeAll(first, second);
                return first.join() + second.join();
            }
        }
    }
}
