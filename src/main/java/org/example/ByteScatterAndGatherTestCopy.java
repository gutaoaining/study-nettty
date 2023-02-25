package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class ByteScatterAndGatherTestCopy {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(9999);
        serverSocketChannel.socket().bind(address);
        int messageLength = 2 + 3 + 4;

    }
}
