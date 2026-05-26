public class Main {
    public static void main(String[] args) {
        Thread numbersThread = new NumbersThread();

        Thread daemonThread = new Thread(new DaemonTask());
        daemonThread.setDaemon(true);

        numbersThread.start();
        daemonThread.start();
    }

    public static class NumbersThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                System.out.println(i);
            }
        }
    }

    public static class DaemonTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am the daemon thread!");
            }
        }
    }
}
