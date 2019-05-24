package concurrency;

/**
 * Deadlock или дедлок или взаимная блокировка —
 * это ошибка, которая происходит когда нити имеют циклическую
 * зависимость от пары синхронизированных объектов. **/

public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend friend1 =
                new Friend("First friend");
        final Friend friend2 =
                new Friend("Second friend");
        new Thread(() -> {
            System.out.println("Thread 1");
            friend1.bow(friend2);
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2");
            friend2.bow(friend1);

        }).start();
    }
}
