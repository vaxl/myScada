package base;

/**
 * Created by U7 on 25.03.2017.
 */
public interface RunnableWithStop extends Runnable {
    void stop();
    String getName();
}
