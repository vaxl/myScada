package entity;


import types.MessageTypes;

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
        return "Message{" +
                "status=" + status.name() +
                '}';
    }

    public Message setStatus(MessageTypes status) {
        this.status = status;
        return this;


    }
}
