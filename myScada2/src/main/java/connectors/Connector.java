package connectors;

import base.RunnableWithStop;
import entity.Message;


public interface Connector extends RunnableWithStop {
    Message read();
    void write(Message message);
    void write(byte[] message);
    boolean init();
    boolean isAlive() ;
    void close();
    void eventWrite(Message message);
}
