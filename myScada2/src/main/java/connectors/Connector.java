package connectors;

import entity.Message;

/**
 * Created by U7 on 12.03.2017.
 */
public interface Connector extends Runnable {
    Message read();
    void write(Message message);
    void write(byte[] message);
    boolean init();
    boolean isAlive() ;
    void close();
    void stop();
    void eventWrite(Message message);
}
