class PrintSequence {
    private static int count = 1;
    private static char letter = 'A';
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread numberThread = new Thread(() -> {
            while (count <= 26) {
                synchronized (lock) {
                    for (int i = 1; i <= count; i++) {
                        System.out.println(i);
                    }
                    lock.notify();
                    try {
                        if (letter <= 'Z') {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread letterThread = new Thread(() -> {
            while (letter <= 'Z') {
                synchronized (lock) {
                    System.out.println(letter);
                    letter++;
                    count++;
                    lock.notify();
                    try {
                        if (letter <= 'Z') {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        numberThread.start();
        letterThread.start();
    }
}