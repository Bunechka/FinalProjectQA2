package page;

public class SharedContext {
    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {

        }
    }
}
