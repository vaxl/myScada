package base;


public interface RunnableWithStop extends Runnable {
    void stop();
    String getName();
}
