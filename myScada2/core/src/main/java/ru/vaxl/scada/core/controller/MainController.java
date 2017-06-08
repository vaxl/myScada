package ru.vaxl.scada.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vaxl.scada.core.model.ThreadManager;
import ru.vaxl.scada.library.base.RunnableWithStop;

/**
 * Created by U7 on 13.03.2017.
 */
@Component
public class MainController  {
    @Autowired
    private ThreadManager threadManager;


    public void start(RunnableWithStop thread) {
        threadManager.startThread(thread);
    }


    public void stop(String name) {
        threadManager.stopThread(name);
    }


    public void exit() {
        threadManager.stopAllThread();
    }

    public void info() {
        threadManager.printAllActiveThreads();
    }
}
