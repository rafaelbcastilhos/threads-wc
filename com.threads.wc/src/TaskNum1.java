public class TaskNum1 implements Runnable {
    private final WC WC;

    public TaskNum1(WC WC) {
        this.WC = WC;
    }
    @Override
    public void run() {
        try {
            this.WC.num1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
