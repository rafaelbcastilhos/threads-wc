public class Main {
    public static void main(String[] args) {
        WC WC = new WC();

        Thread person1 = new Thread(new TaskNum1(WC), "João");
        Thread person2 = new Thread(new TaskNum2(WC), "Pedro");
        Thread person3 = new Thread(new TaskNum1(WC), "Maria");
        Thread person4 = new Thread(new TaskNum2(WC), "Ana");
        Thread cleaner = new Thread(new TaskClear(WC), "Cleaner Lady");
        
        cleaner.setDaemon(true);
        
        person1.start();
        person2.start();
        person3.start();
        person4.start();
        cleaner.start();
    }
}