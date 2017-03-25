package parser;

import entity.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.parsers.RawData;
import types.MessageTypes;
import types.ProtocolTypes;

import java.util.HashMap;

/**
 * Created by U7 on 13.03.2017.
 */
public class MessageParseExecTest {
    private MessageParseExec parser;
    @Before
    public void setUp() throws Exception {
        HashMap<ProtocolTypes,Parser> hashmap = new HashMap<>();
        hashmap.put(ProtocolTypes.rawData,new RawData());
        parser= new MessageParseExec(hashmap);
    }

    @Test
    public void execute() throws Exception {
        Message message = new Message();
        message =parser.execute(ProtocolTypes.rawData,message);
        Assert.assertTrue(message.getStatus()== MessageTypes.NOANSWER);
    }

}