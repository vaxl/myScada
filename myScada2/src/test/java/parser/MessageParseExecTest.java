package parser;

import entity.Message;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by U7 on 13.03.2017.
 */
public class MessageParseExecTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void execute() throws Exception {
        Message message = new Message();
        message =MessageParseExec.execute("RawParser",message);
        System.out.println(message);

    }

}