package ru.vaxl.scada.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import ru.vaxl.scada.core.messages.AppLogger;
import ru.vaxl.scada.library.base.Msg;
import ru.vaxl.scada.library.base.Task;

import java.util.HashMap;
import java.util.Map;

import static ru.vaxl.scada.library.Constants.TextCommon.*;

@Service("ThreadManager")
public class TaskManager {

    @Value("${threadStart}")
    private String threadStart;
    private final ThreadPoolTaskExecutor pool;
    private final Msg msg;
    private final Map<String,Task> activeThreads = new HashMap<>();

    @Autowired
    public TaskManager(ThreadPoolTaskExecutor pool, Msg msg) {
        this.pool = pool;
        this.msg = msg;
    }

    public synchronized void startThread(Task thread){
        msg.print(threadStart + SPACE + thread.getName());
        pool.execute(thread);
        activeThreads.put(thread.getName(),thread);
    }

    public void printAllActiveThreads(){
        StringBuilder all = new StringBuilder();
        all.append("Connections in pool = ").append(pool.getActiveCount()).append(NEW_LINE);
        activeThreads.forEach((k, v) -> all.append("Thread name = ").append(k).append(NEW_LINE));
        msg.print(all.toString());
    }

    public synchronized void stopThread(String name){
        Task thread = activeThreads.get(name);
        if(thread==null) msg.print(name + " not found thread");
            else{
            thread.stop();
            activeThreads.remove(name);
        }
    }

    public synchronized void stopAllThread(){
        activeThreads.forEach((k,v)-> v.stop());
        pool.shutdown();
    }


}
