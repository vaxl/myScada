package view;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by U7 on 12.03.2017.
 */
public class AppLogger {
    private static Logger logger = Logger.getLogger("AppLogger");


    public static void print(String text){
        logger.info(text);
    }

    public static void printDebug(String text){
        logger.debug(text);
    }

    public static void print(String text,Throwable ex){
        logger.error(text,ex);
    }

    public static void printWarn(String text){
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
