package ru.vaxl.scada.core.connectors.decoders

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import ru.vaxl.scada.library.entity.Message
import ru.vaxl.scada.library.types.MessageTypes

class ByteArrayDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()]
        byteBuf.readBytes(bytes)
        out.add(new Message(bytes,MessageTypes.UNKNOWN))
    }
}
