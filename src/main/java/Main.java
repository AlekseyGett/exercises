import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TimeBuffer buffer = new TimeBuffer();

        Chronometer chronometer = new Chronometer(buffer);
        Thread chronometerThread = new Thread(chronometer);
        chronometerThread.start();

        Printer fiveSecondsPrinter = new Printer(buffer, 5);
        Thread fiveSecondsPrinterThread = new Thread(fiveSecondsPrinter);
        fiveSecondsPrinterThread.start();

        Printer sevenSecondsPrinter = new Printer(buffer, 7);
        Thread sevenSecondsPrinterThread = new Thread(sevenSecondsPrinter);
        sevenSecondsPrinterThread.start();

        pressAnyKey();

        chronometerThread.interrupt();
        fiveSecondsPrinterThread.interrupt();
        sevenSecondsPrinterThread.interrupt();
    }

    private static void pressAnyKey() {
        System.out.println("Press any key to exit");

        try {
            System.in.read();
        } catch (IOException ignored) {

        }
    }
}
