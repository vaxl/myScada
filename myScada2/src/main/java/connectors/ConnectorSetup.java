package connectors;

import types.ProtocolTypes;

/**
 * Created by U7 on 12.03.2017.
 */

public class ConnectorSetup {
    private int port;
    private ProtocolTypes parser;

    public ProtocolTypes getParser() {
        return parser;
    }

    public void setParser(ProtocolTypes parser) {
        this.parser = parser;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
