package tictaktoe;

public class Monitor {
    private final int size;
    private int step;

    public Monitor(int size) {
        this.size = size > 0 ? size : 0;
    }
    
    public void forward() {
        ++step;
        
        if (step >= size) {
            step = 0;
        }
    }
    
    public int getStep() {
        return step;
    }
}
