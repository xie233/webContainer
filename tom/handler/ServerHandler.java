package tom.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import tom.config.ServletConfig;
import tom.config.ServletMapping;
import tom.resp.Request1;
import tom.resp.Response1;
import tom.servlet.MainServlet;


import java.util.List;

@ChannelHandler.Sharable
public class ServerHandler  extends ChannelInboundHandlerAdapter{


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Request1 request1 = (Request1) msg;
        String method = request1.getRequestMethod();
        String url = request1.getRequestUrl();
        Response1 response1 = new Response1("Nothing..");
        List<ServletMapping> servletConfig = ServletConfig.servletConfig;
        for (ServletMapping mapping: servletConfig){
            if (mapping.getServletUrl().equalsIgnoreCase(url)){
                try {
                    Class<MainServlet> clazz = (Class<MainServlet>) Class.forName(mapping.getServletClazz());
                    MainServlet servlet = clazz.newInstance();
                    servlet.service(request1,response1);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }

            }
        }
        System.out.println(response1.getContent());
        ctx.writeAndFlush(response1);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
