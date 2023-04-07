import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer implements Runnable {

    ConcurrentLinkedQueue<String> queue;

    public Producer(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.add(String.format("Element - %s", i));
            System.out.println("Producer add element " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}