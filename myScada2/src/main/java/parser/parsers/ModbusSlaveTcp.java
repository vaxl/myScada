package parser.parsers;

import entity.Message;
import parser.Parser;
import types.MessageTypes;

/**
 * Created by U7 on 14.03.2017.
 */
public class ModbusSlaveTcp implements Parser {
    @Override
    public Message execute(Message message) {
        return message.setStatus(MessageTypes.NOANSWER);
    }//// TODO: 14.03.2017  
}