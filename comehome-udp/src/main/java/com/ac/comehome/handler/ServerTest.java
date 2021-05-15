package com.ac.comehome.handler;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * program:comehome_app_server
 * description:appserver
 * author:lsj
 * create:2021-04-17 08:50
 */
public class ServerTest implements Runnable {

    static public void main(String args[]) throws Exception {
        int port = 8889;
        new ServerTest(port);
    }

    private int port;

    public ServerTest(int port) {
        this.port = port;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            //建立
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            SocketAddress address = new InetSocketAddress(port);
            //本地绑定端口
            DatagramSocket ds = dc.socket();
            ds.setReceiveBufferSize(512);
            ds.bind(address);
            //注册
            Selector select = Selector.open();
            dc.register(select, SelectionKey.OP_READ);
            ByteBuffer buffer = ByteBuffer.allocateDirect(512);
            //只为记录接受的字节数
            int number = 0;
            while (true) {
                System.out.println("Listening on port " + port);
                int num = select.select();
                //如果选择器数目为0，则结束循环
                if (num == 0) {
                    continue;
                }
                //得到选择键列表
                Set Keys = select.selectedKeys();
                Iterator it = Keys.iterator();
                //开始监听
                while (it.hasNext()) {
                    SelectionKey k = (SelectionKey) it.next();
                    if ((k.readyOps() & SelectionKey.OP_READ)
                            == SelectionKey.OP_READ) {
                        DatagramChannel cc = (DatagramChannel) k.channel();
                        //非阻塞
                        cc.configureBlocking(false);

                        //接收数据并读到buffer中
                        buffer.clear();
                        SocketAddress client = cc.receive(buffer);
                        System.out.println(client);

                        buffer.flip();
                        if (buffer.remaining() <= 0) {
                            System.out.println("bb is null");
                        }
                        //记录接收到的字节总数
                        number += buffer.remaining();
                        byte b[] = new byte[buffer.remaining()];
                        for (int i = 0; i < buffer.remaining(); i++) {
                            b[i] = buffer.get(i);
                        }
                        String in = new String(b, "utf-8");
                        System.out.println("number::::" + number);
                        System.out.println(in);
                        //执行操作，并回发送
//                        cc.send(buffer, client);
                        //…………
                    }
                }
                Keys.clear();
            }
        } catch (IOException ie) {
            System.err.println(ie);
        }
    }
}
