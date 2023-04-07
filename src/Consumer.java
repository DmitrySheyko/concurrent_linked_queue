import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable {

    ConcurrentLinkedQueue<String> queue;

    public Consumer(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String st;
        for (int i = 0; i < 10; i++) {
            try {
                while ((st = queue.poll()) != null) {
                    System.out.println("Consumer get " + st);
                }
                Thread.sleep(100);
            } catch (NoSuchElementException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}