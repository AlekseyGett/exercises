public class TimeBuffer {
    private int time = 0;

    public synchronized void put(int time) {
        this.time = time;
        notifyAll();
    }

    public synchronized int getUpdate(int oldTime) throws InterruptedException {
        while (time == oldTime) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new InterruptedException();
            }
        }

        return time;
    }
}
