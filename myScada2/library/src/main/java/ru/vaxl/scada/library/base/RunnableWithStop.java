package ru.vaxl.scada.library.base;


public interface RunnableWithStop extends Runnable {
    void stop();
    String getName();
}
