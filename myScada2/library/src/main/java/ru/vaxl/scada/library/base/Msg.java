package ru.vaxl.scada.library.base;

/**
 * Created by U7 on 22.08.2017.
 */
public interface Msg {
    void print(String textCode);
    void print(String textCode, Object ... params);
    void warn(String textCode);
    void warn(String textCode, Object ... params);
    void debug(String text);
    void print(String text,Throwable ex);
}
