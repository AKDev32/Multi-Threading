package ThreadSynchronisation;

public class SynchronisationDemo {

    private static int counter = 0;

    public static void main(String[] args) {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value : " + counter);
    }

    private synchronized static void increment () {
        counter++;
    }
}

/*
* 1. Load
* 2. Increment
* 3. Set back the value
* counter = 0; increment value = 1; Setting back the value to the counter< Thread 1
* counter = 0; increment value = 1 (2) < Thread 2
*/
