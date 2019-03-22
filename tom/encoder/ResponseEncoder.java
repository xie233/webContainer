package tom.encoder;


import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import  io.netty.buffer.ByteBuf;
import tom.resp.Response1;

import java.nio.charset.Charset;
import java.util.List;

public class ResponseEncoder extends MessageToMessageEncoder<Response1>{


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Response1 response1,
                          List<Object> list) throws Exception {


        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.directBuffer();

        StringBuffer sb = new StringBuffer();

        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-type:text/html\n");
        sb.append("\r\n");
        sb.append("<html><body>");
        sb.append(response1.getContent());
        sb.append("</body></html>");
        buffer.writeBytes(sb.toString().getBytes(Charset.forName("UTF-8")));

        list.add(buffer);

    }


}
