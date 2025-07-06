package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 7; i++) {
                service.execute(new Work(i));
            }
        }
    }
}

class Work implements Runnable {
    private final int workID;

    public Work (int workID) {
        this.workID = workID;
    }

    @Override
    public void run() {
        System.out.println("Task ID " + workID + " being executed by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
