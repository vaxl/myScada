package ru.vaxl.scada.core.connectors;

import ru.vaxl.scada.library.base.Task;
import ru.vaxl.scada.library.entity.Message;


public interface Connector extends Task {
    Message read();
    void write(Message message);
    void write(byte[] message);
    boolean init();
    boolean isAlive() ;
    void close();
    void eventWrite(Message message);
}
