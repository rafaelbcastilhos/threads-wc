package main.java;

public class TaskNum2 implements Runnable {
    private final WC WC;

    public TaskNum2(WC WC) {
        this.WC = WC;
    }
    @Override
    public void run() {
        try {
            this.WC.num2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
