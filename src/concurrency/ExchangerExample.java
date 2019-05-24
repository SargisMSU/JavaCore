package concurrency;

import java.util.concurrent.Exchanger;

class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new UseString(exchanger);
        new MakeString(exchanger);
    }

    static class MakeString implements Runnable{
        Exchanger<String> ex;
        String str;

        MakeString(Exchanger<String> ex) {
            this.ex = ex;
            str = "";
            new Thread(this).start();
        }

        @Override
        public void run() {
            char ch = 'A';
            for (int i = 0 ; i < 3; i++ ) {
                for (int j = 0; j < 5; j++)
                    str += (char) ch++;
                try {
                    str = ex.exchange(str);
                } catch (InterruptedException exc) {
                    System.out.println(exc);
                }
            }
        }
    }

    static class UseString implements Runnable{
        Exchanger<String> exchanger;
        String string;

        public UseString(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    string = exchanger.exchange("");
                    System.out.println("Received: " + string);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
}
