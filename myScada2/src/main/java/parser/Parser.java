package parser;

import entity.Message;

/**
 * Created by U7 on 12.03.2017.
 */
public interface Parser {
    Message execute(Message message);
}
