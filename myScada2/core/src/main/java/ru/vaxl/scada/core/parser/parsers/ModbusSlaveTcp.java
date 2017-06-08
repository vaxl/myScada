package ru.vaxl.scada.core.parser.parsers;

import ru.vaxl.scada.core.parser.Parser;
import ru.vaxl.scada.library.entity.Message;
import ru.vaxl.scada.library.types.MessageTypes;

/**
 * Created by U7 on 14.03.2017.
 */
public class ModbusSlaveTcp implements Parser {
    @Override
    public Message execute(Message message) {
        return message.setStatus(MessageTypes.NOANSWER);
    }//// TODO: 14.03.2017  
}