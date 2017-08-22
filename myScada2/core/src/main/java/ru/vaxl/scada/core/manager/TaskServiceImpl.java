package ru.vaxl.scada.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vaxl.scada.library.base.Task;

/**
 * Created by U7 on 22.08.2017.
 */
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskManager taskManager;

    @Autowired
    public TaskServiceImpl(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void start(Task thread) {
        taskManager.startThread(thread);
    }

    public void stop(String name) {
        taskManager.stopThread(name);
    }

    public void exit() {
        taskManager.stopAllThread();
    }

    public void info() {
        taskManager.printAllActiveThreads();
    }
}
