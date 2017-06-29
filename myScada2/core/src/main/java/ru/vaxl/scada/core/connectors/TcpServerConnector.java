package ru.vaxl.scada.core.connectors;

import org.springframework.stereotype.Component;
import ru.vaxl.scada.core.view.AppLogger;
import ru.vaxl.scada.library.entity.Message;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static ru.vaxl.scada.library.types.MessageTypes.*;


/**
 * Created by U7 on 12.03.2017.
 */
@Component("tcpServerConnector")
public class TcpServerConnector extends BaseConnector {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream in;
    private OutputStream out;

    public Message read() {
        try {
            while (true) {
                if(!isAlive() |event.get() ) break;
                if (in.available() > 0) {
                    byte[] arr = new byte[in.available()];
                    in.read(arr);
                    return new Message().setRaw(arr).setStatus(OK);
                } else  Thread.sleep(10);
            }
        } catch (Exception e) { AppLogger.print(error,e); stop();}
        return new Message().setStatus(NOTHING);
    }

    public void write(Message message) {
        if(message!=null)
            write(message.getRaw());
    }

    public boolean init() {
        try{
            serverSocket = new ServerSocket(setup.getPort());
            AppLogger.print(portOpened);
            socket = serverSocket.accept();
            AppLogger.print(connected);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            return true;
        }catch (Exception e) {
            AppLogger.print(noConnection); return false;}
    }


    public boolean isAlive(){
        return socket.isConnected() & !socket.isClosed();
    }


    public void write(byte[] message) {
        try {
            if(message!=null)
                out.write(message);
        } catch (IOException e) {
            AppLogger.print(error,e); stop();}
    }


    public void close() {
        try {
            if (serverSocket!=null & !serverSocket.isClosed()) serverSocket.close();
            if (socket!=null ) {
                socket.close();
                AppLogger.print(portClosed);
            }
        } catch (IOException e) {
            AppLogger.print(error,e);}
    }

    public void run() {
        run.set(true);
        if (init()){
            while (run.get()) {
                Message inMsg = read();
                if (inMsg.getStatus() == NOTHING) {
                    if (run.get() & !event.get()) {
                        AppLogger.print(error);
                        stop();
                        break;
                    } else if (event.get()){
                        write(eventMsg);
                        event.set(false);
                    }
                }
                else {
                    AppLogger.print("in " + inMsg.toString());
                    Message outMsg = parser.execute(setup.getParser(), inMsg);
                    if (outMsg.getStatus() != NOANSWER) {
                        write(outMsg);
                        AppLogger.print(outMsg.toString());
                    }
                }
            }
        }
    }
}
