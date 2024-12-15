import java.util.Random;

class NumberToWordsConverter extends Thread {
    private final Consumer consumer;
    private final Random rand = new Random();

    public NumberToWordsConverter(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            int number = rand.nextInt(10000);
            System.out.println("Producer generated: " + number);
            consumer.consume(number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private int number;

    public synchronized void consume(int number) {
        this.number = number;
        notify();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    wait();
                    System.out.println("Consumer received number: " + number);
                    System.out.println("In words: " + numberToWords(number));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        StringBuilder words = new StringBuilder();

        if (num / 1000 > 0) {
            words.append(ones[num / 1000]).append(" thousand ");
            num %= 1000;
        }

        if (num / 100 > 0) {
            words.append(ones[num / 100]).append(" hundred ");
            num %= 100;
        }

        if (num > 0) {
            if (num < 20) {
                words.append(ones[num]);
            } else {
                words.append(tens[num / 10]).append(" ");
                if (num % 10 > 0) {
                    words.append(ones[num % 10]);
                }
            }
        }

        return words.toString().trim();
    }
}

public class NumberToWordsMain {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        NumberToWordsConverter converter = new NumberToWordsConverter(consumer);

        consumer.start();
        converter.start();
    }
}