package ru.vaxl.scada.library.entity;

import ru.vaxl.scada.library.types.MessageTypes;

import java.util.Arrays;

/**
 * Created by U7 on 12.03.2017.
 */
public class Message {
    private byte[] raw;
    private MessageTypes status;

    public byte[] getRaw() {
        return raw;
    }

    public Message setRaw(byte[] raw) {
        this.raw = raw;
        return this;
    }

    public MessageTypes getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String rawStr="empty";
        if(raw!=null)  rawStr = Arrays.toString(raw);
        return "Message{" +
                "status = " + status.name() + " raw = " + rawStr+
                '}';
    }

    public Message setStatus(MessageTypes status) {
        this.status = status;
        return this;


    }
}
