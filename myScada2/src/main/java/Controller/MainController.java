package controller;

import base.RunnableWithStop;
import connectors.Connector;
import model.ThreadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
