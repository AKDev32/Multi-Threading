package BasicMultiThreading;

public class DemoUserThread {

    public static void main(String[] args) {
        Thread bgThread = new Thread(new DaemonHelper());
        Thread userThread = new Thread(new UserThreadHelper());

        bgThread.setDaemon(true);
        bgThread.start();
        userThread.start();
    }

}

class DaemonHelper implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count < 100) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("DaemonHelper running....");
        }
    }
}

class UserThreadHelper implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User thread done with execution....");
    }
}
