package ru.vaxl.scada.core.messages;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import ru.vaxl.scada.library.base.Msg;

import java.util.Locale;

import static java.util.Locale.*;

/**
 * Created by U7 on 12.03.2017.
 */
@Component
public class AppLogger implements Msg {
    private static Logger logger = Logger.getLogger("AppLogger");
    private final ResourceBundleMessageSource text;
    private final Locale locale = ENGLISH;

    @Autowired
    public AppLogger(ResourceBundleMessageSource text) {
        this.text = text;
    }

    @Override
    public void print(String textCode){
        logger.info(text.getMessage(textCode, null, locale));
    }

    @Override
    public void print(String textCode, Object ... params){
        logger.info(text.getMessage(textCode, params, locale));
    }

    @Override
    public void warn(String textCode){
        logger.warn(text.getMessage(textCode, null, locale));
    }

    @Override
    public void warn(String textCode, Object ... params){
        logger.info(text.getMessage(textCode, params, locale));
    }

    @Override
    public void debug(String text){
        logger.debug(text);
    }

    @Override
    public void print(String text,Throwable ex){
        logger.error(text,ex);
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
