package connectors;

import entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import parser.MessageParseExec;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created by U7 on 12.03.2017.
 */

abstract class BaseConnector implements Connector {
    protected volatile AtomicBoolean run   = new AtomicBoolean();
    protected volatile AtomicBoolean event   = new AtomicBoolean();
    protected Message eventMsg;
    @Autowired
    protected MessageParseExec parser;
    @Autowired
    protected ConnectorSetup setup;

    @Value("${portClosed}")
    protected String portClosed;
    @Value("${portOpened}")
    protected String portOpened;
    @Value("${connected}")
    protected String connected;
    @Value("${error}")
    protected String error;
    @Value("${noConnection}")
    protected String noConnection;


    public String getName(){
        return setup.getName();
    }

    public void eventWrite(Message message) {
        event.set(true);
        this.eventMsg = message;
    }

    public void stop() {
        run.set(false);
        close();
    }

    @Override
    public String toString() {
        return "Connector{ "+ this.getClass().getSimpleName() +" name = " + getName() +" }";
    }
}
