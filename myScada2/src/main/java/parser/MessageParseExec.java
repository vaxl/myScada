package parser;

import entity.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by U7 on 12.03.2017.
 */
public class MessageParseExec {
    private static Map<String, Parser> commandMap;
    private final static String DIR = "parser.parsers.";

    static {
        commandMap = new HashMap<>();
        //// TODO: 12.03.2017
    }

    private MessageParseExec() {}


    public static Message execute(String operation, Message message) {
        return commandMap.get(operation).execute(message);
    }
}
