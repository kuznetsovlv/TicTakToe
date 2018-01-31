package tictaktoe;

public class TicTakToe {
    
    private static final String [] strs = { "tic-", "tak-", "toe\n" };

    public static void main(String[] args) {
        Monitor monitor = new Monitor(strs.length);
        TicTakToeThread [] threads = new TicTakToeThread[strs.length];
        
        for (int i = 0; i < strs.length; i++) {
            threads[i] = new TicTakToeThread(i, strs[i], monitor);
            threads[i].start();
        }
        
        for(TicTakToeThread thread: threads) {
            thread.join();
        }
    }
    
}
