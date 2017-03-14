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
        connect.run();
    }

    @Override
    public void stop() {
        connect.stop();
    }

    @Override
    public void exit() {
        connect.stop();
    }
}
