public class Printer implements Runnable {
    private final TimeBuffer buffer;
    private final int period;

    Printer(TimeBuffer buffer, int period) {
        this.buffer = buffer;
        this.period = period;
    }

    @Override
    public void run() {
        int time = 0;

        while (!Thread.interrupted()) {
            try {
                time = buffer.getUpdate(time);
            } catch (InterruptedException e) {
                break;
            }

            if (time % period != 0) {
                continue;
            }

            String formattedTime = formatTime(time);
            System.out.println(formattedTime);
        }

        Thread.currentThread().interrupt();
    }

    private String formatTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
