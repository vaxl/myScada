package view;

import org.apache.log4j.Logger;

/**
 * Created by U7 on 12.03.2017.
 */
public class AppLogger {
    private static Logger logger = Logger.getLogger("main");


    public static void print(String text){
        logger.info(text);
    }

    public static void print(String text,Throwable ex){
        logger.error(text,ex);
    }

    public static void printWarn(String text){
        logger.warn(text);
    }


}
