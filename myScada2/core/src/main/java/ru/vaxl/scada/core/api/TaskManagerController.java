package ru.vaxl.scada.core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vaxl.scada.core.manager.TaskService;
import ru.vaxl.scada.library.base.Task;

/**
 *
 * Created by U7 on 21.08.2017.
 */

@RestController
@RequestMapping("/manager")
public class TaskManagerController {

    private final TaskService taskService;
    private final Task NettyConnector;

    @Autowired
    public TaskManagerController(TaskService taskService, @Qualifier("nettyConnector") Task NettyConnector) {
        this.taskService = taskService;
        this.NettyConnector = NettyConnector;
    }

    @GetMapping(value = "/start")
    public void start(){
        taskService.start(NettyConnector);
    }

    @GetMapping(value = "/stop")
    public void stop(){
        taskService.stop("noName");
    }

    @GetMapping(value = "/info")
    public void info(){
        taskService.info();
    }

    @GetMapping(value = "/exit")
    public void exit(){
        taskService.exit();
    }
}
