package ru.vaxl.scada.core.connectors.handlers

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import ru.vaxl.scada.library.entity.Message
import ru.vaxl.scada.library.types.MessageTypes

import static ru.vaxl.scada.core.view.AppLogger.print

/**
 * Created by U7 on 29.06.2017.
 */
class ReverseHandler  extends ChannelInboundHandlerAdapter {

    @Override
    void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush()
    }

    @Override
    void channelRead(ChannelHandlerContext ctx, Object msg) {
        def message = (Message) msg
        def bytes = new byte[message.raw.length]
        message.raw.eachWithIndex { byte entry, int i -> bytes[bytes.size() - (i+1)] = entry }
        println new Message(bytes, MessageTypes.UNKNOWN)
    }

    @Override
    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        print cause
        ctx.close()
    }
}