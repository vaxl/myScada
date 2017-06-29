package ru.vaxl.scada.core.connectors

import groovy.transform.ToString
import org.springframework.stereotype.Component
import ru.vaxl.scada.library.types.ConnectionTypes
import ru.vaxl.scada.library.types.Priority
import ru.vaxl.scada.library.types.ProtocolTypes

@ToString
class ConnectorSetup {
    int port
    ProtocolTypes parser
    ConnectionTypes channel
    Priority priority
    String name
}