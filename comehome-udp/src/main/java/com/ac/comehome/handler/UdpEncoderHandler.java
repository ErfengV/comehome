package com.ac.comehome.handler;



import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.util.List;
/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-18 19:48
 */

@Service
public class UdpEncoderHandler extends MessageToMessageEncoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdpEncoderHandler.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Object o, List list) throws Exception {
        byte[] data = o.toString().getBytes();
        ByteBuf buf = ctx.alloc().buffer(data.length);
        buf.writeBytes(data);
        //指定客户端的IP及端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("10.108.58.115", 6668);
        list.add(new DatagramPacket(buf, inetSocketAddress));
        LOGGER.info("{}发送消息{}:" + o.toString());
    }
}
