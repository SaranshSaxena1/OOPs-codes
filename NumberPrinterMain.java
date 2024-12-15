class NumberPrinter extends Thread {
    private int limit;
    private String type;

    public NumberPrinter(int limit, String type) {
        this.limit = limit;
        this.type = type;
    }

    public void run() {
        switch (type) {
            case "natural":
                printNaturalNumbers();
                break;
            case "even":
                printEvenNumbers();
                break;
            case "odd":
                printOddNumbers();
                break;
        }
    }

    private void printNaturalNumbers() {
        for (int i = 1; i <= limit; i++) {
            System.out.println("Natural: " + i);
        }
    }

    private void printEvenNumbers() {
        for (int i = 1; i <= limit; i++) {
            System.out.println("Even: " + (2 * i));
        }
    }

    private void printOddNumbers() {
        for (int i = 0; i < limit; i++) {
            System.out.println("Odd: " + (2 * i + 1));
        }
    }
}

public class NumberPrinterMain {
    public static void main(String[] args) {
        int n = 7; // Set the value of n
        NumberPrinter naturalThread = new NumberPrinter(n, "natural");
        NumberPrinter evenThread = new NumberPrinter(n, "even");
        NumberPrinter oddThread = new NumberPrinter(n, "odd");

        naturalThread.start();
        evenThread.start();
        oddThread.start();
    }
}