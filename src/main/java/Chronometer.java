public class Chronometer implements Runnable {
    private final TimeBuffer buffer;
    private int time = 0;

    public Chronometer(TimeBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
                buffer.put(time++);
            } catch (InterruptedException e) {
                break;
            }
        }

        Thread.currentThread().interrupt();
    }
}
