package connectors;

import entity.Message;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.atomic.AtomicBoolean;

import static view.AppLogger.print;

/**
 * Created by U7 on 12.03.2017.
 */

abstract class BaseConnector implements Connector {
    protected volatile AtomicBoolean run   = new AtomicBoolean();
    protected volatile AtomicBoolean event   = new AtomicBoolean();
    protected Message eventMsg;

    @Value("#{con.portClosed}")
    protected String portClosed;
    @Value("#{con.portOpen}")
    protected String portOpened;
    @Value("#{con.connected}")
    protected String connected;
    @Value("#{con.error}")
    protected String error;

    public void eventWrite(Message message) {
        event.set(true);
        this.eventMsg = message;
    }

    public void stop() {
        run.set(false);
        close();
        print(portClosed);
    }
}
