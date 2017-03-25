package connectors;

import base.RunnableWithStop;
import entity.Message;

/**
 * Created by U7 on 12.03.2017.
 */
public interface Connector extends RunnableWithStop {
    Message read();
    void write(Message message);
    void write(byte[] message);
    boolean init();
    boolean isAlive() ;
    void close();
    void eventWrite(Message message);
}
