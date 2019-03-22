package tom.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import tom.handler.ServerHandler;
import tom.decoder.RequestDecoder;
import tom.encoder.ResponseEncoder;

import java.net.InetSocketAddress;


public class TomServer {

    private final int port;

    public TomServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {

        EventLoopGroup accepter  = new NioEventLoopGroup();
//        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            final ServerHandler serverHandler = new ServerHandler();
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(accepter)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new RequestDecoder());
                            pipeline.addLast(new ResponseEncoder());
                            pipeline.addLast(serverHandler);
                        }
                    });

            ChannelFuture future = bootstrap.bind().sync();
            System.out.println(" server start up on port : " + port);
            future.channel().closeFuture().sync();
        } finally {
            accepter.shutdownGracefully();

        }
    }


    public static void main(String[] args) throws InterruptedException{
        TomServer server = new TomServer(8090);
        server.start();
    }
}
