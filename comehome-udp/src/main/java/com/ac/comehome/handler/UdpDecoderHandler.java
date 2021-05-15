package com.ac.comehome.handler;




import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-18 19:45
 */
@Service
public class UdpDecoderHandler extends MessageToMessageDecoder<DatagramPacket>  {
    private static final Logger LOGGER = LoggerFactory.getLogger(UdpDecoderHandler.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> out) throws Exception {
        ByteBuf byteBuf = datagramPacket.content();
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        String msg = new String(data);
        LOGGER.info("{}收到消息{}:" + msg);
        System.out.println(msg);
        out.add(msg); //将数据传入下一个handler
    }
}
