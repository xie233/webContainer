package tom.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.http.HttpRequestDecoder;
import tom.resp.Request1;

import java.nio.charset.Charset;
import java.util.List;

public class RequestDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {



        int readable = byteBuf.readableBytes();// 获取buffer所有的可读字节（header + body）
        byte[] bytes = new byte[readable];

        byteBuf.readBytes(bytes);
        String req = new String(bytes);
        String head = req.split("\n")[0];
        String requestMethod = head.split("\\s")[0];
        String requestUrl = head.split("\\s")[1];

        Request1 request1 = new Request1(requestMethod,requestUrl);
        System.out.println(request1);
        list.add(request1);
    }



    }

