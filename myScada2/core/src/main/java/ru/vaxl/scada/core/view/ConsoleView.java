package ru.vaxl.scada.core.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vaxl.scada.core.connectors.Connector;
import ru.vaxl.scada.core.controller.MainController;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by U7 on 12.03.2017.
 */
@Service("consoleView")
public class ConsoleView implements View{
    @Autowired
    private MainController controller;
    @Autowired
    private Connector connect;

    private static final Scanner scanner = new Scanner(System.in);
    private volatile AtomicBoolean run = new AtomicBoolean();

    @Override
    public void run() {
        run.set(true);
        while (run.get()){
            String cmd = scanner.nextLine();
            String[] cmdParameters = cmd.split(" ");
            if(cmdParameters.length<1) break;

            switch (cmdParameters[0]){
                case "start" :{
                    controller.start(connect);
                    break;
                }
                case "stop" :{
                    if(cmdParameters.length<2) controller.stop("noName");
                    else controller.stop(cmdParameters[1]);
                    break;
                }
                case "exit" :{
                    controller.exit();
                    break;
                }
                case "info" : {
                    controller.info();
                    break;
                }
            }
            
        }
    }

    @Override
    public void stop() {
        run.set(false);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
