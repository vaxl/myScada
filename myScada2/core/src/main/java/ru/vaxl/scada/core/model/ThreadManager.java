package ru.vaxl.scada.core.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import ru.vaxl.scada.core.view.AppLogger;
import ru.vaxl.scada.library.base.RunnableWithStop;

import java.util.HashMap;
import java.util.Map;

@Service("ThreadManager")
public class ThreadManager {

    private ThreadPoolTaskExecutor pool;
    @Value("${threadStart}")
    private String threadStart;
    private Map<String,RunnableWithStop> activeThreads = new HashMap<>();

    @Autowired
    public void setPool(ThreadPoolTaskExecutor pool) {
        this.pool = pool;
    }

    public synchronized void startThread(RunnableWithStop thread){
        AppLogger.print(threadStart + " " + thread.getName());
        pool.execute(thread);
        activeThreads.put(thread.getName(),thread);
    }


    public  void printAllActiveThreads(){
        StringBuilder all = new StringBuilder();
        all.append("Connectioms in pool = ").append(pool.getActiveCount()).append("\n");
        activeThreads.forEach((k, v) -> all.append("Thread name = ").append(k).append("\n"));
        AppLogger.print(all.toString());
    }

    public synchronized void stopThread(String name){
        RunnableWithStop thread = activeThreads.get(name);
        if(thread==null) AppLogger.print(name + " not found thread");
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
