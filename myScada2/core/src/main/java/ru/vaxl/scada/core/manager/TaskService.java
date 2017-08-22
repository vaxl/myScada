package ru.vaxl.scada.core.manager;

import ru.vaxl.scada.library.base.Task;

/**
 * Created by U7 on 22.08.2017.
 */
public interface TaskService {
    void start(Task thread);
    void stop(String name);
    void exit();
    void info();
}
