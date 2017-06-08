package ru.vaxl.scada.core.parser;

import ru.vaxl.scada.library.entity.Message;
import ru.vaxl.scada.library.types.ProtocolTypes;

import java.util.Map;



/**
 * Created by U7 on 12.03.2017.
 */
public class MessageParseExec {
    private  Map<ProtocolTypes, Parser> commandMap;

    public MessageParseExec(Map<ProtocolTypes, Parser> commandMap) {
        this.commandMap = commandMap;
    }

    public  Message execute(ProtocolTypes operation, Message message) {
        return commandMap.get(operation).execute(message);
    }

}
