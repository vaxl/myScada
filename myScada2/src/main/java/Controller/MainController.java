package Controller;

import connectors.Connector;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U7 on 13.03.2017.
 */
public class MainController implements Controller  {
    @Autowired
    private Connector connect;

    @Override
    public void start() {
        Thread thread = new Thread(connect);
        thread.start();
    }

    @Override
    public void stop() {
        connect.stop();
    }

    @Override
    public void exit() {
        if(connect.isAlive()) connect.stop();
    }
}
