package ru.vaxl.scada.core.messages;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.vaxl.scada.library.base.Msg;

/**
 * Created by U7 on 12.03.2017.
 */
@Component
public class AppLogger implements Msg {
    private static Logger logger = Logger.getLogger("AppLogger");


    public void print(String text){
        logger.info(text);
    }

    public void debug(String text){
        logger.debug(text);
    }

    public void print(String text,Throwable ex){
        logger.error(text,ex);
    }

    public void warn(String text){
        logger.warn(text);
    }

    public static void setLevel(Level level){
        logger.setLevel(level);
    }

    public static void offLogger(){
        setLevel(Level.OFF);
    }

    public static void allLogger(){
        setLevel(Level.ALL);
    }
    public static void onlyErrorLogger(){
        setLevel(Level.ERROR);
    }
}
