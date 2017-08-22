package ru.vaxl.scada.core.connectors;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vaxl.scada.core.connectors.decoders.ByteArrayDecoder;
import ru.vaxl.scada.core.connectors.handlers.MsgToLogHandler;
import ru.vaxl.scada.core.connectors.handlers.ReverseHandler;
import ru.vaxl.scada.library.base.Msg;
import ru.vaxl.scada.library.base.Task;

@Component
public  class NettyConnector  implements Task {
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private final ConnectorSetup setup;
    private final Msg msg;

    @Autowired
    public NettyConnector(ConnectorSetup setup, Msg msg) {
        this.setup = setup;
        this.msg = msg;
    }

    private void init() {
        // Configure the server.
        bossGroup = new NioEventLoopGroup(setup.getPriority().ordinal());
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new SetupServerInitializer());
            Channel ch = b.bind(setup.getPort()).sync().channel();
            ch.closeFuture().sync();
        } catch (Exception e){
            msg.print("",e);
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    @Override
    public void run() {
        init();
    }

    @Override
    public void stop() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    @Override
    public String getName() {
        return setup.getName();
    }
}

class SetupServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
//        p.addLast("toByte",new ByteArrayDecoder());
        p.addLast("toByte2",new ByteArrayDecoder());
        p.addLast(new ReverseHandler());
        p.addLast(new MsgToLogHandler());
    }
}