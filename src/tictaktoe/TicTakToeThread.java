package tictaktoe;

public class TicTakToeThread implements Runnable {
    private final int step;
    private final String str;
    private final Thread thread;
    private final Monitor monitor;
    
    private static final int ITERATIONS = 10;

    public TicTakToeThread(int step, String str, Monitor monitor) {
        this.step = step;
        this.str = str;
        this.monitor = monitor;
        thread = new Thread(this, str);
    }
    
    public void start() {
        thread.start();
    }
    
    public void join() {
        try {
            thread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    @Override
    public void run() {
        try {
            for (int i = 0; i < TicTakToeThread.ITERATIONS; ++i) {
                synchronized(monitor) {
                    while (monitor.getStep() != step) {
                        monitor.wait();
                    }
                }
                
                System.out.print(str);
                monitor.forward();
                
                synchronized(monitor) {
                    monitor.notifyAll();
                    
                    if (i < ITERATIONS -1) {
                        monitor.wait();
                    }
                }
            }
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
