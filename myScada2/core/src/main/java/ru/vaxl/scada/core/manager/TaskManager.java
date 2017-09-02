package ru.vaxl.scada.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import ru.vaxl.scada.library.base.Msg;
import ru.vaxl.scada.library.base.Task;

import java.util.HashMap;
import java.util.Map;

@Service("ThreadManager")
public class TaskManager {

    private final ThreadPoolTaskExecutor pool;
    private final Msg msg;
    private final Map<String,Task> activeThreads = new HashMap<>();

    @Autowired
    public TaskManager(ThreadPoolTaskExecutor pool, Msg msg) {
        this.pool = pool;
        this.msg = msg;
    }

    public synchronized void startThread(Task thread){
        msg.print("thread.start", thread.getName());
        pool.execute(thread);
        activeThreads.put(thread.getName(),thread);
    }

    public void printAllActiveThreads(){
        msg.print("pool.connections", pool.getActiveCount());
        activeThreads.forEach((k, v) -> msg.print("thread.name", k));
    }

    public synchronized void stopThread(String name){
        Task thread = activeThreads.get(name);
        if(thread==null) msg.print("thread.notFound", name);
            else{
            thread.stop();
            activeThreads.remove(name);
        }
    }

    public synchronized void stopAllThread(){
        activeThreads.forEach((k,v)-> v.stop());
        activeThreads.clear();
        pool.shutdown();
    }


}
