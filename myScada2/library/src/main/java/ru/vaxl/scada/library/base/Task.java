package ru.vaxl.scada.library.base;


public interface Task extends Runnable {
    void stop();
    String getName();
}
