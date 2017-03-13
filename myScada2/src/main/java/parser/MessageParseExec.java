package parser;

import entity.Message;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static view.AppLogger.print;


/**
 * Created by U7 on 12.03.2017.
 */
public class MessageParseExec {
    private static Map<String, Parser> commandMap;
    private final static String DIR = "parser\\parsers.";

    static {
        commandMap = new HashMap<>();
        File[] files = new File(DIR).listFiles();
        if(files!=null)
            for(File f : files)
                try {
                    commandMap.put(f.getName(), (Parser) Class.forName(f.getCanonicalPath()).newInstance());
                } catch (Exception e) {
                    print("No parsers",e);
                }

    }

    private MessageParseExec() {}


    public static Message execute(String operation, Message message) {
        return commandMap.get(operation).execute(message);
    }
}
