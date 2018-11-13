import java.util.stream.IntStream;

public class ThreadTest {

    public static void main(String[] args) {

        System.out.println("Start");

        final MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("End");



        IntStream.range(1, 10).forEach(
                i -> {
                    try {
                        Thread.sleep(100);
                        System.out.println("Interrupting");
                        myThread.interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

    }


    public static class MyThread extends Thread {


        @Override
        public void run() {

            IntStream.range(1, 21).forEach(i -> {
                try {
                    Thread.sleep(100);
                    System.out.println("Loop " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
    }

}
