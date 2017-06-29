package ru.vaxl.scada.core.connectors.handlers

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

import static ru.vaxl.scada.core.view.AppLogger.print

/**
 * Created by U7 on 29.06.2017.
 */
class MsgToLogHandler extends ChannelInboundHandlerAdapter {

    @Override
    void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush()
    }

    @Override
    void channelRead(ChannelHandlerContext ctx, Object msg) {
        print msg.toString()
    }

    @Override
    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        print cause
        ctx.close()
    }
}