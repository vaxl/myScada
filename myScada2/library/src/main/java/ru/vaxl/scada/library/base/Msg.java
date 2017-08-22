package ru.vaxl.scada.library.base;

/**
 * Created by U7 on 22.08.2017.
 */
public interface Msg {
    void print(String text);
    void debug(String text);
    void print(String text,Throwable ex);
    void warn(String text);
}
